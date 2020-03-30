package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GrupaController {


    @Autowired
    private GrupaServiceImpl grupaServiceImpl;


    @GetMapping("/grupy")
    public ModelAndView getAllProduct( Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("grupy/grupy");
        modelAndView.addObject("grupy", grupaServiceImpl.getAllGrupa());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }


}
