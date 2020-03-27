package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.service.KsiazeczkaServiceImpl;

@Controller
public class KsiazeczkaController 
{
	@Autowired
	private KsiazeczkaServiceImpl ksiazeczkaServiceImpl;
	
	
    @GetMapping("/ksiazeczki") // ścieżka na której zostanie obsłużona metoda
    public String getAllKsiazeczki(Model model, Authentication authentication) 
    {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("ksiazeczki", ksiazeczkaServiceImpl.getAllKsiazeczki());

        return "ksiazeczka/ksiazeczki";
    }
	 @PostMapping("/ksiazeczki/dodaj")
	    public String createKsiazeczka(@RequestBody Turysta turysta,
	                                RedirectAttributes redirectAttributes) 
	 	{

	        Ksiazeczka ksiazeczka = new Ksiazeczka(turysta);
	        ksiazeczkaServiceImpl.createKsiazeczka(ksiazeczka); // puść inserta do bazy

	        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

	        return "redirect:/ksiazeczki";
	    }
}
	
