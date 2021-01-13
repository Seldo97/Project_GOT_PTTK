package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private KsiazeczkaServiceImpl ksiazeczkaService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/turystaodznaki") // ścieżka na której zostanie obsłużona metoda
    public String getAllTurystaOdznaka(Model model) {

        model.addAttribute("turystaodznaki", turystaOdznakaServiceImpl.getAllTurystaOdznaka());

        return "turystaodznaka/turystaodznaki";
    }

    @PostMapping("/turystaodznaki/dodaj")
    public String createTurystaOdznaka(@RequestParam(value = "idOdznaka") Odznaka odznaka, /// ???
                                       @RequestParam(value = "idTurysta") Turysta turysta, /// ???
                                       @RequestParam(value = "data") Date data,
                                       RedirectAttributes redirectAttributes) {
        TurystaOdznaka turystaOdznaka = new TurystaOdznaka(odznaka, turysta, data);
        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka); // puść inserta do bazy


        redirectAttributes.addFlashAttribute("success_msg", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

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


        if (idTurystaOdznaka != null) {
            TurystaOdznaka turystaOdznaka = turystaOdznakaServiceImpl.getOneById(idTurystaOdznaka);
            model.addAttribute("turystaOdznaka", turystaOdznaka);
            model.addAttribute("update", "1");  //???
        }

        return "turystaodznaki/turystaodznakiForm";
    }

    @PostMapping("/turystaodznaki/update/{idTurystaOdznaka}")
    public String updateTurystaOdznaka(@RequestParam(value = "idOdznaka") Odznaka odznaka,
                                       @RequestParam(value = "idTurysta") Turysta turysta,
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
        Turysta turysta = turystaServiceImpl.getOneById(idTurysta);

        //** DATA
        java.sql.Date dataUrodzenia = (java.sql.Date) turysta.getDataUrodzenia();
        LocalDate dataUr = dataUrodzenia.toLocalDate();
        LocalDate dzisiaj = LocalDate.now();
        //**

        boolean niepelnosprawnosc = turysta.isNiepelnosprawnosc();
        
        List<Odznaka> odznaki = new ArrayList<Odznaka>();



        if (dataUr.plusYears(7).compareTo(dzisiaj) > 0) {
            if (odznakiTurysty.size() == 0) {
                odznaki.add(odznakaServiceImpl.getOneByNazwa("W góry - brązowa"));

            } else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaServiceImpl.findOdznaka("W góry - brązowa", idTurysta))) {
                odznaki.add(odznakaServiceImpl.getOneByNazwa("W góry - srebrna"));

            } else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaServiceImpl.findOdznaka("W góry - srebrna", idTurysta))) {
                odznaki.add(odznakaServiceImpl.getOneByNazwa("W góry - złota"));
            }
        } else {
            if (niepelnosprawnosc == true) {
                if (odznakiTurysty.size() == 0) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Popularna"));
                } else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaServiceImpl.findOdznaka("Popularna", idTurysta))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - brązowa"));
                } else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaServiceImpl.findOdznaka("Mała - brązowa", idTurysta))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - srebrna"));
                } else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaServiceImpl.findOdznaka("Mała - srebrna", idTurysta))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - złota"));
                }
            } else {
                if (odznakiTurysty.size() == 0) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Popularna"));
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Popularna", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - brązowa", idTurysta)))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - brązowa"));
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - brązowa", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - srebrna", idTurysta)))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - srebrna"));
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - srebrna", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - złota", idTurysta)))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Mała - złota"));
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Mała - złota", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - brązowa", idTurysta)))) {
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Duża - brązowa"));
                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - mała"));
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - brązowa", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - srebrna", idTurysta))))  {
                                odznaki.add(odznakaServiceImpl.getOneByNazwa("Duża - srebrna"));
                                if(odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - duża", idTurysta)))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - duża"));
                                }else if (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - mała"));
                                }
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - srebrna", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - złota", idTurysta))))  {
                                odznaki.add(odznakaServiceImpl.getOneByNazwa("Duża - złota"));
                                if(odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - duża", idTurysta)))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - duża"));
                                }else if (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - mała"));
                                }
                } else if (odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Duża - złota", idTurysta))) {
                                if(odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta)) && (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - duża", idTurysta)))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - duża"));
                                }else if (!odznakiTurysty.contains(turystaOdznakaServiceImpl.findOdznaka("Za wytrwałość - mała", idTurysta))){
                                    odznaki.add(odznakaServiceImpl.getOneByNazwa("Za wytrwałość - mała"));
                                }
                }
            }


        }


        String imieNazwisko = turysta.getImie() + " " + turysta.getNazwisko();
        model.addAttribute("odznakiTurysty", odznakiTurysty);
        model.addAttribute("odznaki", odznaki);
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("imieNazwisko", imieNazwisko);
        model.addAttribute("idTurysta", idTurysta);

        return "turysta/odznakiTurysty";
    }

    @GetMapping("/turystaodznaki/MojeOdznaki")
    public String showMojeOdznaki(Model model, Authentication authentication) {

        Uzytkownik uzytkownik = uzytkownikServiceImpl.getLoggedUserDetails(authentication);
        Turysta turysta = uzytkownik.getTurysta();
        List<TurystaOdznaka> odznakiTurysty = turystaOdznakaServiceImpl.findByIdTurysta(turysta.getIdTurysta());

        String imieNazwisko = turystaServiceImpl.getOneById(turysta.getIdTurysta()).getImie() + " "
                + turystaServiceImpl.getOneById(turysta.getIdTurysta()).getNazwisko();
        model.addAttribute("odznakiTurysty", odznakiTurysty);
        ;
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("imieNazwisko", imieNazwisko);

        return "turysta/odznakiTurysty";
    }

    @GetMapping("/turystaodznaki/odznaki")
    public void showOdznakiTurysty(@RequestParam Integer idTurysta, Model model, Authentication authentication) {


        List<TurystaOdznaka> odznakiTurysty = turystaOdznakaServiceImpl.findByIdTurysta(idTurysta);

        model.addAttribute("odznakiTurysty", odznakiTurysty);

        model.addAttribute("LoggedUser", authentication);

    }

    @GetMapping("/turystaodznaki/ranking")
    public String showRanking(Model model, Authentication authentication) {

       List<Turysta> turysci = turystaServiceImpl.getAllTurysta();
        List<Integer> odznaki = new ArrayList<Integer>();

       for(Turysta turysta : turysci){
            odznaki.add(turystaOdznakaServiceImpl.ileOdznak(turysta.getIdTurysta()));
       }
        model.addAttribute("odznaki", odznaki);
        model.addAttribute("turysci", turysci);
        model.addAttribute("LoggedUser", authentication);

        return "turysta/ranking";
    }

    @PostMapping("/turystaodznaki/przypiszOdznake")
    public String addOdznakatoTurysta(@ModelAttribute TurystaOdznaka turystaOdznaka,
                                      HttpServletRequest request,
                                      RedirectAttributes redirectAttributes) {

        String referer = request.getHeader("Referer");

        if (turystaOdznakaServiceImpl.checkOfUnique(turystaOdznaka.getOdznaka(), turystaOdznaka.getTurysta()) != null) {
            redirectAttributes.addFlashAttribute("success_msg", "Ten turysta posiada już tę odznakę!");
            return "redirect:" + referer;
        }

        Ksiazeczka ksiazeczka = turystaOdznaka.getTurysta().getKsiazeczka();
        ksiazeczka.setSumaPunktow((int)((ksiazeczka.getSumaPunktow() - turystaOdznaka.getOdznaka().getPunkty()) * 0.25));
        ksiazeczka.setPowiadomienie(1);
        ksiazeczka.setZgloszona(0);
        ksiazeczkaService.createKsiazeczka(ksiazeczka);

        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka);
        emailService.sendEmailAboutNewBadge(turystaOdznaka);
        redirectAttributes.addFlashAttribute("success_msg", "Przydzielono odznake turyście!");

        return "redirect:" + referer;
    }
    
}
