package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import grupa4.projektzespolowy.GOTTPKProjekt.service.KsiazeczkaWycieczkaServiceImpl;

@Controller
public class KsiazeczkaWycieczkaController 
{
	@Autowired
	private KsiazeczkaWycieczkaServiceImpl ksiazeczkaWycieczkaServiceImpl;
	
	 @GetMapping("/ksiazeczkiWycieczki") // ścieżka na której zostanie obsłużona metoda
	    public String getAllKsiazeczki(Model model, Authentication authentication) 
	    {

	        model.addAttribute("LoggedUser", authentication);
	        model.addAttribute("ksiazeczkiWycieczki", ksiazeczkaWycieczkaServiceImpl.getAllKsiazeczkiWycieczki());

	        return "ksiazeczkaWycieczka/ksiazeczkiWycieczki";
	    }
}
