package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Regulamin;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RegulaminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@Controller
public class MainController {
    @Autowired
    private RegulaminServiceImpl regulaminServiceImpl;


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

    @GetMapping({"/regulamin"})
    public String regiulamin(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("regulamin", regulaminServiceImpl.getAllRegulamin());

        //System.out.println(exampleInt);

        return "regulamin/regulamin";
    }


    @GetMapping({"/regulamin/updateForm"})
    public String regiulaminEdycja(ModelMap model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("regulamin", regulaminServiceImpl.getAllRegulamin());

        //System.out.println(exampleInt);

        return "regulamin/regulaminEdycja";
    }


    @PostMapping("/regulamin/update")
    public String updateZamowienie(@RequestParam(value = "tekstNaglowek") String tekstNaglowek,
                                   @RequestParam(value = "tekstRegulamin") String tekstRegulamin,
                                   RedirectAttributes redirectAttributes) {


        Regulamin regulamin = regulaminServiceImpl.getOneById(1);

        regulamin.setTekstNaglowek(tekstNaglowek);
        regulamin.setTekstRegulamin(tekstRegulamin);


        regulaminServiceImpl.createRegulamin(regulamin);
        redirectAttributes.addFlashAttribute("success_msg", "Zmiany zostały przyjęte pomyślnie");
        return "redirect:/regulamin";
    }


//    @GetMapping("/prevPage")
//    public String goToPrevPage(HttpServletRequest request){
//
//        return "redirect:" + request.getHeader("Referer");
//    }

}
