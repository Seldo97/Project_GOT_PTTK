package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaOdznakaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TurystaOdznakaController {

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private TurystaOdznakaServiceImpl turystaOdznakaServiceImpl;

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private TurystaServiceImpl turystaServiceImpl;

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
    public String removeTurystaOdznaka(@PathVariable Integer idTurystaOdznaka) {

        turystaOdznakaServiceImpl.removeTurystaOdznaka(idTurystaOdznaka);

        return "redirect:/turystaodznaki";
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


        String imieNazwisko =  turystaServiceImpl.getOneById(idTurysta).getImie() + " " + turystaServiceImpl.getOneById(idTurysta).getNazwisko();
        model.addAttribute("odznakiTurysty", odznakiTurysty);
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("imieNazwisko", imieNazwisko);
        return  "turysta/odznakiTurysty";
    }
}
