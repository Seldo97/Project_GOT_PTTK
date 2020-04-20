package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.service.PunktServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PunktController {
    @Autowired
    private PunktServiceImpl punktServiceImpl;


    @GetMapping("/punkty")
    public ModelAndView getAllProduct(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("punkty/punkty");
        modelAndView.addObject("punkty", punktServiceImpl.getAllPunkt());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }

//    @GetMapping("/punktyPasma/{idPasmo}")
//    public ModelAndView getAllPasmoForGrupa(@PathVariable int idPasmo, Authentication authentication) {
//
//        ModelAndView modelAndView = new ModelAndView("punkty/punktyPasma");
//        modelAndView.addObject("punkty", punktServiceImpl.getAllPunktByIdPasmo(idPasmo));
//        modelAndView.addObject("LoggedUser", authentication);
//
//        return modelAndView;
//    }
}
