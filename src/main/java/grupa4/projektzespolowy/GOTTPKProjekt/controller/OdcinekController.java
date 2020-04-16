package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.service.OdcinekServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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

}

