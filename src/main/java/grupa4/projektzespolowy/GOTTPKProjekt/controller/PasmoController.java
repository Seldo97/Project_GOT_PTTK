package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.service.PasmoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasmoController {

    @Autowired
    private PasmoServiceImpl pasmoServiceImpl;


    @GetMapping("/pasma")
    public ModelAndView getAllProduct(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("pasma/pasma");
        modelAndView.addObject("pasma", pasmoServiceImpl.getAllPasmo());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }
}
