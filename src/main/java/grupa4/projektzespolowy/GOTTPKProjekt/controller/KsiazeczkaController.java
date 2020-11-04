package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;
import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class KsiazeczkaController {
    @Autowired
    private KsiazeczkaServiceImpl ksiazeczkaServiceImpl;
    @Autowired
    private WycieczkaServiceImpl wycieczkaService;
    @Autowired
    private UzytkownikServiceImpl uzytkownikService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PrzodownikService przodownikService;
 
    List<PrzodownikDTO> przodownicy = new ArrayList<>();

    @GetMapping("/ksiazeczki") // ścieżka na której zostanie obsłużona metoda
    public String getAllKsiazeczki(Model model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("ksiazeczki", ksiazeczkaServiceImpl.getAllKsiazeczki());

        return "ksiazeczka/ksiazeczki";
    }
//	 @PostMapping("/ksiazeczki/dodaj")
//	    public String createKsiazeczka(@RequestBody Turysta turysta,
//	                                RedirectAttributes redirectAttributes)
//	 	{
//
//	        Ksiazeczka ksiazeczka = new Ksiazeczka(turysta);
//	        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka); // puść inserta do bazy
//
//	        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane
//
//	        return "redirect:/ksiazeczki";
//	    }

    @GetMapping({"/ksiazeczka/MojaKsiazeczka", "/ksiazeczka/{idKsiazeczka}"})
    public String getMojaKsiazeczka(Model model,
                                    Authentication authentication,
                                    @PathVariable(required = false) Integer idKsiazeczka) {

        Ksiazeczka ksiazeczka = null;
        Turysta turysta = null;

        if (idKsiazeczka != null) {

            ksiazeczka = ksiazeczkaServiceImpl.getOneById(idKsiazeczka);
            turysta = ksiazeczka.getTurysta();

            List<Wycieczka> wycieczki = wycieczkaService.getAllZatwierdzoneWycieczki(ksiazeczka);
            model.addAttribute("wycieczki", wycieczki);

        } else {

            Uzytkownik uzytkownik = uzytkownikService.getLoggedUserDetails(authentication);
            turysta = uzytkownik.getTurysta();
            ksiazeczka = ksiazeczkaServiceImpl.getOneByTurysta(turysta);

            if (ksiazeczka != null) {
                List<Wycieczka> wycieczki = ksiazeczka.getWycieczki();
                model.addAttribute("wycieczki", wycieczki);
                przodownicy = przodownikService.getAllPrzodownik();
    			
                
                
            }

        }

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("przodownicy", przodownicy);
        model.addAttribute("turysta", turysta);
        model.addAttribute("ksiazeczka", ksiazeczka);

        return "ksiazeczka/mojaKsiazeczka";
    }

    @PostMapping("/ksiazeczka/stworz")
    public String createKsiazeczka(@ModelAttribute Ksiazeczka ksiazeczka,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes) {

        String referer = request.getHeader("Referer");

        redirectAttributes.addFlashAttribute("success_msg", "Utworzono książeczkę pomyślnie ✅");
        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka);

        return "redirect:" + referer;
    }

    @GetMapping("/ksiazeczka/zglos/{idKsiazeczka}")
    public String reportKsiazeczka(@PathVariable("idKsiazeczka") Integer idKsiazeczka,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes) {


        Ksiazeczka ksiazeczka = ksiazeczkaServiceImpl.getOneById(idKsiazeczka);
        ksiazeczka.setZgloszona(1);
        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka);
        emailService.sendEmailAboutReportedBook(ksiazeczka);

        redirectAttributes.addFlashAttribute("info_msg", "Książeczka została zgłoszona do referatu ✅");

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/ksiazeczka/zgloszone")
    public String showZgloszoneKsiazeczki(Model model,
                                          Authentication authentication) {

        List<Ksiazeczka> zgloszoneKsiazeczki = ksiazeczkaServiceImpl.getZgloszoneWycieczki();

        //zgloszoneKsiazeczki.get(1).getTurysta().getImie();

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("zgloszoneKsiazeczki", zgloszoneKsiazeczki);

        return "ksiazeczka/zgloszoneKsiazeczki";
    }

    @GetMapping("/ksiazeczka/odrzuc/{idKsiazeczka}")
    public String odrzucZgloszonaKsiazeczke(@PathVariable("idKsiazeczka") Integer idKsiazeczka,
                                            HttpServletRequest request,
                                            RedirectAttributes redirectAttributes){

        Ksiazeczka ksiazeczka = ksiazeczkaServiceImpl.getOneById(idKsiazeczka);
        ksiazeczka.setZgloszona(0);
        ksiazeczka.setPowiadomienie(2);
        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka);

        redirectAttributes.addFlashAttribute("info_msg", "Zgłoszenie zostało odrzucone");

        return "redirect:/ksiazeczka/zgloszone";
    }

    @GetMapping("/ksiazeczka/zamknij/{idKsiazeczka}")
    public String zamknijPowiadomienieKsiazeczki(@PathVariable("idKsiazeczka") Integer idKsiazeczka,
                                            HttpServletRequest request){

        Ksiazeczka ksiazeczka = ksiazeczkaServiceImpl.getOneById(idKsiazeczka);
        ksiazeczka.setPowiadomienie(0);
        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka);

        return "redirect:" + request.getHeader("Referer");
    }

}
	
