package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdznakaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdznakaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OdznakaController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private OdznakaServiceImpl odznakaServiceImpl;

    @GetMapping("/odznaki") // ścieżka na której zostanie obsłużona metoda
    public String getAllOdznaka(Model model) {

        model.addAttribute("odznaki", odznakaServiceImpl.getAllOdznaka());

        return "odznaka/odznaki";
    }

    @PostMapping("/odznaki/dodaj")
    public String createOdznaka(@RequestParam(value="nazwa") String nazwa,
                                   RedirectAttributes redirectAttributes) {
        Odznaka odznaka = new Odznaka(nazwa);
        odznakaServiceImpl.createOdznaka(odznaka); // puść inserta do bazy


        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/odznaki";
    }

    @GetMapping("/odznaki/usun/{id_odznaka}")
    public String removeOdznaka(@PathVariable Integer id_odznaka) {

        odznakaServiceImpl.removeOdznaka(id_odznaka);

        return "redirect:/odznaki";
    }

    @GetMapping({"/odznaki/form", "/odznaki/form/{id_odznaka}"})
    public String formOdznaka(Model model, @PathVariable(required = false) Integer id_odznaka) {


        if(id_odznaka != null){
            Odznaka odznaka = odznakaServiceImpl.getOneById(id_odznaka);
            model.addAttribute("odznaka", odznaka);
            model.addAttribute("update", "1");  //???
        }

        return "odznaka/odznakiForm";
    }

    @PostMapping("/odznaki/update/{id_odznaka}")
    public String updateOdznaka(@RequestParam(value="nazwa") String nazwa,
                                   @PathVariable Integer id_odznaka) {

        Odznaka odznaka = odznakaServiceImpl.getOneById(id_odznaka);

        odznaka.setNazwa(nazwa);

        odznakaServiceImpl.createOdznaka(odznaka);

        return "redirect:/odznaki";
    }
}
