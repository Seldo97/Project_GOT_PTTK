package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {

    @GetMapping({"/"})
    public String indexPage(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
;
        //System.out.println(exampleInt);

        return "index";
    }

    @GetMapping("/panel")
    public String adminPanel(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);

        return "admin/panel";
    }

//    @GetMapping("/prevPage")
//    public String goToPrevPage(HttpServletRequest request){
//
//        return "redirect:" + request.getHeader("Referer");
//    }

}
