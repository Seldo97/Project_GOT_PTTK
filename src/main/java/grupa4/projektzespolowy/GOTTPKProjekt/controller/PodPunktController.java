package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.service.PodPunktServiceImpl;

@Controller
public class PodPunktController {
	
	    
	 @Autowired
	    private PodPunktServiceImpl podPunktServiceImpl;
	 
	   @GetMapping("/podpunkty")
	    public ModelAndView getAllProduct(Authentication authentication) {

	        ModelAndView modelAndView = new ModelAndView("podpunkt/podPunkt");
	        modelAndView.addObject("podpunkty", podPunktServiceImpl.getAllPodPunkt());
	        modelAndView.addObject("LoggedUser", authentication);

	        return modelAndView;
	    }

}
