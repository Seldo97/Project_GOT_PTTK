package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class TrasaController {

    @Autowired
    private WycieczkaServiceImpl wycieczkaService;

    @Autowired
    private TrasaServiceImpl trasaService;

    @GetMapping("/trasy/{idWycieczka}")
    public String showTrasyWycieczki(@PathVariable int idWycieczka,
                                     Authentication authentication,
                                     Model model) {

        List<Trasa> trasy = trasaService.getAllByIdWycieczka(idWycieczka);
        Wycieczka wycieczka = wycieczkaService.getOneById(idWycieczka);

        model.addAttribute("trasy", trasy);
        model.addAttribute("wycieczka", wycieczka);
        model.addAttribute("LoggedUser", authentication);

        return "trasa/trasyWycieczki";
    }

}
