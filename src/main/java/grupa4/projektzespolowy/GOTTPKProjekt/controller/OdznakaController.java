package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdznakaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OdznakaController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private OdznakaServiceImpl odznakaServiceImpl;

    @GetMapping("/odznaki") // ścieżka na której zostanie obsłużona metoda
    public String getAllOdznaka(Model model,
                                Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odznaki", odznakaServiceImpl.getAllOdznaka());

        return "odznaka/odznaki";
    }

    @PostMapping("/odznaki/dodaj")
    public String createOdznaka(@ModelAttribute Odznaka odznaka,
                                RedirectAttributes redirectAttributes) {

        odznakaServiceImpl.createOdznaka(odznaka); // puść inserta do bazy

        redirectAttributes.addFlashAttribute("success_msg", "Dodano wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/odznaki";
    }

    @GetMapping("/odznaki/usun/{idOdznaka}")
    public String removeOdznaka(@PathVariable Integer idOdznaka,
                                RedirectAttributes redirectAttributes) {

        odznakaServiceImpl.removeOdznaka(idOdznaka);
        redirectAttributes.addFlashAttribute("success_msg", "Usunięto wiersz pomyślnie!");

        return "redirect:/odznaki";
    }

    @GetMapping({"/odznaki/form", "/odznaki/form"})
    public String formOdznaka(Model model,
                              @RequestParam(required = false, value="id") Integer idOdznaka,
                              Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);

        if(idOdznaka != null){
            Odznaka odznaka = odznakaServiceImpl.getOneById(idOdznaka);
            model.addAttribute("odznaka", odznaka);
            model.addAttribute("update", "1");  //???
        }

        return "odznaka/odznakiForm";
    }

    @PostMapping("/odznaki/update")
    public String updateOdznaka(@ModelAttribute Odznaka odznaka) {

        Odznaka odznakaToEdit = odznakaServiceImpl.getOneById(odznaka.getIdOdznaka());

        odznakaToEdit.setNazwa(odznaka.getNazwa());
        odznakaToEdit.setPunkty(odznaka.getPunkty());
        odznakaServiceImpl.createOdznaka(odznakaToEdit);

        return "redirect:/odznaki";
    }


}
