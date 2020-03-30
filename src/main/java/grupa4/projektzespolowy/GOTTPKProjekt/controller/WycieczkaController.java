package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;


@Controller
public class WycieczkaController {
	
	 @Autowired // podłączamy Servicy z których bedzimy koszystać
	    private WycieczkaServiceImpl wycieczkaServiceImpl;
	 
	 @GetMapping("/wycieczki") // ścieżka na której zostanie obsłużona metoda
	    public String getAllZdjeciaWycieczek(Model model, Authentication authentication) 
	    {

	        model.addAttribute("LoggedUser", authentication);
	        model.addAttribute("wycieczki", wycieczkaServiceImpl.getAllWycieczki());

	        return "wycieczka/wycieczka";
	    }
}
