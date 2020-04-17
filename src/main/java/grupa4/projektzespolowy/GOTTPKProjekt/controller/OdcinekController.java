package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdcinekServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PasmoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;


import java.util.Arrays;

@Controller
public class OdcinekController
{
    @Autowired
    private OdcinekServiceImpl odcinekServiceImpl;
    @Autowired
    private GrupaServiceImpl grupaServiceImpl;
    @Autowired
    private PasmoServiceImpl pasmoServiceImpl;


    @GetMapping("/odcinki") // ścieżka na której zostanie obsłużona metoda
    public String getAllOdcinki(Model model, Authentication authentication)
    {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllOdcinki());

        return "odcinek/odcinki";
    }

    @GetMapping("/odcinkiWybor") // ścieżka na której zostanie obsłużona metoda
    public String getAllPasmoGrupa(Model model, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("grupy", grupaServiceImpl.getAllGrupa());
        model.addAttribute("pasma", pasmoServiceImpl.getAllPasmo());

        return "odcinek/odcinkiWybor";
    }

    @GetMapping("/odcinki/allGrupa/{idGrupa}") // ścieżka na której zostanie obsłużona metoda
    public String getAllGrupa(Model model, @PathVariable Integer idGrupa, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllByPasmo_Grupa_IdGrupa(idGrupa));

        return "odcinek/odcinki";
    }

    @GetMapping("/odcinki/allPasmo/{idPasmo}") // ścieżka na której zostanie obsłużona metoda
    public String getAllPasmo(Model model,@PathVariable Integer idPasmo, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllByPasmo_IdPasmo(idPasmo));

        return "odcinek/odcinki";
    }


}

