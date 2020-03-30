package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdznakaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaOdznakaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Controller
public class TurystaOdznakaController {

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private TurystaOdznakaServiceImpl turystaOdznakaServiceImpl;

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private TurystaServiceImpl turystaServiceImpl;

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private OdznakaServiceImpl odznakaServiceImpl;

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private UzytkownikServiceImpl uzytkownikServiceImpl;

    @GetMapping("/turystaodznaki") // ścieżka na której zostanie obsłużona metoda
    public String getAllTurystaOdznaka(Model model) {

        model.addAttribute("turystaodznaki", turystaOdznakaServiceImpl.getAllTurystaOdznaka());

        return "turystaodznaka/turystaodznaki";
    }

    @PostMapping("/turystaodznaki/dodaj")
    public String createTurystaOdznaka(@RequestParam(value="idOdznaka") Odznaka odznaka, /// ???
                                       @RequestParam(value="idTurysta") Turysta turysta, /// ???
                                        RedirectAttributes redirectAttributes) {
        TurystaOdznaka turystaOdznaka = new TurystaOdznaka(odznaka, turysta);
        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka); // puść inserta do bazy


        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/turystaodznaki";
    }

    @GetMapping("/turystaodznaki/usun/{idTurystaOdznaka}")
    public String removeTurystaOdznaka(@PathVariable Integer idTurystaOdznaka,
                                       HttpServletRequest request) {

        turystaOdznakaServiceImpl.removeTurystaOdznaka(idTurystaOdznaka);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping({"/turystaodznaki/form", "/turystaodznaki/form/{idTurystaOdznaka}"})
    public String formTurystaOdznaka(Model model, @PathVariable(required = false) Integer idTurystaOdznaka) {


        if(idTurystaOdznaka != null){
            TurystaOdznaka turystaOdznaka = turystaOdznakaServiceImpl.getOneById(idTurystaOdznaka);
            model.addAttribute("turystaOdznaka", turystaOdznaka);
            model.addAttribute("update", "1");  //???
        }

        return "turystaodznaki/turystaodznakiForm";
    }

    @PostMapping("/turystaodznaki/update/{idTurystaOdznaka}")
    public String updateTurystaOdznaka(@RequestParam(value="idOdznaka") Odznaka odznaka,
                                       @RequestParam(value="idTurysta") Turysta turysta,
                                        @PathVariable Integer idTurystaOdznaka) {

        TurystaOdznaka turystaOdznaka = turystaOdznakaServiceImpl.getOneById(idTurystaOdznaka);

        turystaOdznaka.setOdznaka(odznaka);
        turystaOdznaka.setTurysta(turysta);

        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka);

        return "redirect:/turystaodznaki";
    }

    @GetMapping("/turystaodznaki/znajdzOdznakiTurysty")
    public String findTurystaOdznakaByIdTurysta(@RequestParam Integer idTurysta, Model model, Authentication authentication) {

        List<TurystaOdznaka> odznakiTurysty = turystaOdznakaServiceImpl.findByIdTurysta(idTurysta);
        //List<Odznaka> odznaki = odznakaServiceImpl.getAllOdznaka();

        List<Odznaka> odznakiTurystyFilter = odznakiTurysty
                .stream()
                .map(TurystaOdznaka::getOdznaka)
                .collect(Collectors.toList());
        List<Odznaka> odznaki = odznakaServiceImpl.getAllOdznaka()
                .stream()
                .filter(not(odznakiTurystyFilter::contains))
                .collect(Collectors.toList());

        String imieNazwisko =  turystaServiceImpl.getOneById(idTurysta).getImie() + " " + turystaServiceImpl.getOneById(idTurysta).getNazwisko();
        model.addAttribute("odznakiTurysty", odznakiTurysty);
        model.addAttribute("odznaki", odznaki);
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("imieNazwisko", imieNazwisko);
        model.addAttribute("idTurysta", idTurysta);

        return  "turysta/odznakiTurysty";
    }

    @GetMapping("/turystaodznaki/MojeOdznaki")
    public String showMojeOdznaki(Model model, Authentication authentication) {

        Uzytkownik uzytkownik = uzytkownikServiceImpl.getLoggedUserDetails(authentication);
        Turysta turysta = uzytkownik.getTurysta();
        List<TurystaOdznaka> odznakiTurysty = turystaOdznakaServiceImpl.findByIdTurysta(turysta.getIdTurysta());

        String imieNazwisko =  turystaServiceImpl.getOneById(turysta.getIdTurysta()).getImie() + " "
                + turystaServiceImpl.getOneById(turysta.getIdTurysta()).getNazwisko();
        model.addAttribute("odznakiTurysty", odznakiTurysty);;
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("imieNazwisko", imieNazwisko);

        return  "turysta/odznakiTurysty";
    }

    @PostMapping("/turystaodznaki/przypiszOdznake")
    public String addOdznakatoTurysta(@ModelAttribute TurystaOdznaka turystaOdznaka,
                                      HttpServletRequest request,
                                      RedirectAttributes redirectAttributes){

        String referer = request.getHeader("Referer");

        if(turystaOdznakaServiceImpl.checkOfUnique(turystaOdznaka.getOdznaka(), turystaOdznaka.getTurysta()) != null){
            redirectAttributes.addFlashAttribute("wiadomosc", "Ten turysta posiada już tę odznakę!");
            return "redirect:" + referer;
        }

        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka);
        redirectAttributes.addFlashAttribute("wiadomosc", "Przydzielono odznake turyście!");

        return "redirect:" + referer;
    }



}
