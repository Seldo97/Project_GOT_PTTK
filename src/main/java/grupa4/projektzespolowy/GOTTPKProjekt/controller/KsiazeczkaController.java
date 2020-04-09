package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grupa4.projektzespolowy.GOTTPKProjekt.service.KsiazeczkaServiceImpl;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class KsiazeczkaController 
{
	@Autowired
	private KsiazeczkaServiceImpl ksiazeczkaServiceImpl;
	@Autowired
	private UzytkownikServiceImpl uzytkownikService;
	@Autowired
	private TurystaServiceImpl turystaService;
	
	
    @GetMapping("/ksiazeczki") // ścieżka na której zostanie obsłużona metoda
    public String getAllKsiazeczki(Model model, Authentication authentication) 
    {

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

    @GetMapping("/ksiazeczka/MojaKsiazeczka")
    public String getMojaKsiazeczka(Model model, Authentication authentication){

        Uzytkownik uzytkownik = uzytkownikService.getLoggedUserDetails(authentication);
        Turysta turysta = uzytkownik.getTurysta();
        Ksiazeczka ksiazeczka = ksiazeczkaServiceImpl.getOneByTurysta(turysta);

        if(ksiazeczka != null){
            List<Wycieczka> wycieczki = ksiazeczka.getWycieczki();
            model.addAttribute("wycieczki", wycieczki);
        }

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("turysta", turysta);
        model.addAttribute("ksiazeczka", ksiazeczka);

        return "ksiazeczka/mojaKsiazeczka";
    }

    @PostMapping("/ksiazeczka/stworz")
    public String createKsiazeczka(@ModelAttribute Ksiazeczka ksiazeczka,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes){

        String referer = request.getHeader("Referer");

        redirectAttributes.addFlashAttribute("success_msg", "Utworzono książeczkę pomyślnie");
        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka);

        return "redirect:" + referer;
    }


}
	
