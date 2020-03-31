package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdcinekServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;

@Controller
public class OdcinekController
{
    @Autowired
    private OdcinekServiceImpl odcinekServiceImpl;


    @GetMapping("/odcinki") // ścieżka na której zostanie obsłużona metoda
    public String getAllOdcinki(Model model, Authentication authentication)
    {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllOdcinki());

        return "odcinek/odcinki";
    }
    @PostMapping("/odcinki/dodaj")
    public String createOdcinek(
            @RequestParam(value="punkty_wejscie") Integer punktyWejscie,
            @RequestParam(value="punkty_powrot") Integer punktyPowrot,
            @RequestParam(value="otwarty") Boolean otwarty,
            @PathVariable Integer idPasmo,
            @PathVariable Integer idPunktPoczatkowy,
            @PathVariable Integer idPunktKoncowy,
            RedirectAttributes redirectAttributes,
            Authentication authentication
    {

        Odcinek odcinek = new Odcinek( punktPoczatkowy, punktKoncowy);
        odcinekServiceImpl.createOdcinek(odcinek); // puść inserta do bazy

        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/odcinki";
    }
}

