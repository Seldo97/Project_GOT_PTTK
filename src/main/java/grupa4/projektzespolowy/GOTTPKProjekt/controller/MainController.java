package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;


@Controller
public class MainController {

    @GetMapping({"/"})
    public String indexPage(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);

        return "index";
    }

    @GetMapping("/panel")
    public String adminPanel(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);

        return "admin/panel";
    }

}
