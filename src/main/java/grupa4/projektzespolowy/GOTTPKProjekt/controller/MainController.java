package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {

    @GetMapping({"/", "/{exampleInt}"})
    public String indexPage(ModelMap model, Authentication authentication, @PathVariable(required = false) Integer exampleInt) {

        model.addAttribute("LoggedUser", authentication);

        model.addAttribute("exampleInt", exampleInt);

        System.out.println(exampleInt);

        return "index";
    }

    @GetMapping("/panel")
    public String adminPanel(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);

        return "admin/panel";
    }

}
