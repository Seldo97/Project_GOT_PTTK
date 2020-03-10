package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @GetMapping("/")
    public ModelAndView indexPage() {

        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;

    }

}
