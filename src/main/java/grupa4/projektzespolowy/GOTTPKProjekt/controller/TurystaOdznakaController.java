package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TurystaOdznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaOdznakaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class TurystaOdznakaController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private TurystaOdznakaServiceImpl turystaOdznakaServiceImpl;

    @GetMapping("/turystaodznaki") // ścieżka na której zostanie obsłużona metoda
    public String getAllTurystaOdznaka(Model model) {

        model.addAttribute("turystaodznaki", turystaOdznakaServiceImpl.getAllTurystaOdznaka());

        return "turystaodznaka/turystaodznaki";
    }

    @PostMapping("/turystaodznaki/dodaj")
    public String createTurystaOdznaka(@RequestParam(value="id_odznaka") Odznaka id_odznaka,
                                       @RequestParam(value="id_turysta") Turysta id_turysta,
                                RedirectAttributes redirectAttributes) {
        TurystaOdznaka turystaOdznaka = new TurystaOdznaka(id_odznaka, id_turysta);
        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka); // puść inserta do bazy


        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/turystaodznaki";
    }

    @GetMapping("/turystaodznaki/usun/{id_turysta_odznaka}")
    public String removeTurystaOdznaka(@PathVariable Integer id_turysta_odznaka) {

        turystaOdznakaServiceImpl.removeTurystaOdznaka(id_turysta_odznaka);

        return "redirect:/turystaodznaki";
    }

    @GetMapping({"/turystaodznaki/form", "/turystaodznaki/form/{id_turysta_odznaka}"})
    public String formTurystaOdznaka(Model model, @PathVariable(required = false) Integer id_turysta_odznaka) {


        if(id_turysta_odznaka != null){
            TurystaOdznaka turystaOdznaka = turystaOdznakaServiceImpl.getOneById(id_turysta_odznaka);
            model.addAttribute("turystaOdznaka", turystaOdznaka);
            model.addAttribute("update", "1");  //???
        }

        return "turystaodznaki/turystaodznakiForm";
    }

    @PostMapping("/turystaodznaki/update/{id_turysta_odznaka}")
    public String updateTurystaOdznaka(@RequestParam(value="id_odznaka") Odznaka id_odznaka,
                                       @RequestParam(value="id_turysta") Turysta id_turysta,
                                @PathVariable Integer id_turysta_odznaka) {

        TurystaOdznaka turystaOdznaka = turystaOdznakaServiceImpl.getOneById(id_turysta_odznaka);

        turystaOdznaka.setOdznaka(id_odznaka);
        turystaOdznaka.setTurysta(id_turysta);

        turystaOdznakaServiceImpl.createTurystaOdznaka(turystaOdznaka);

        return "redirect:/turystaodznaki";
    }
}
