package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class TrasaController {

    @Autowired
    private WycieczkaServiceImpl wycieczkaService;

    @Autowired
    private GrupaServiceImpl grupaService;

    @Autowired
    private TrasaServiceImpl trasaService;

    @GetMapping("/trasy/{idWycieczka}")
    public String showTrasyWycieczki(@PathVariable int idWycieczka,
                                     Authentication authentication,
                                     Model model) {

        List<Trasa> trasy = trasaService.getAllByIdWycieczka(idWycieczka);
        List<Grupa> grupy = grupaService.getAllGrupa();
        Wycieczka wycieczka = wycieczkaService.getOneById(idWycieczka);

        model.addAttribute("trasy", trasy);
        model.addAttribute("wycieczka", wycieczka);
        model.addAttribute("grupy", grupy);
        model.addAttribute("LoggedUser", authentication);

        return "trasa/trasyWycieczki";
    }

    @PostMapping("/trasa/wycieczki/dodaj_odcinek")
    public String createTrasa(@ModelAttribute Trasa trasa,
                              HttpServletRequest request,
                              RedirectAttributes redirectAttributes) {

        trasaService.createTrasa(trasa);
        redirectAttributes.addFlashAttribute("success_msg", "Dodano trasę pomyślnie ✅");
        redirectAttributes.addFlashAttribute("warning_msg", "Skonfiguruj odcinki trasy ⚠️");

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/trasa/zrealizuj/{idTrasa}")
    public String zrealizujTrase(@PathVariable int idTrasa,
                                 HttpServletRequest request) {

        Trasa trasa = trasaService.getOneById(idTrasa);
        if (trasa.getZrealizowana() == 0) {
            trasa.setZrealizowana(1);
            if (trasa.getDubel() == 0)
                trasa.getWycieczka()
                        .setSumaPunktow(trasa.getWycieczka().getSumaPunktow() + trasa.getSuma_punktow());
        } else {
            trasa.setZrealizowana(0);
            if (trasa.getDubel() == 0)
                trasa.getWycieczka()
                        .setSumaPunktow(trasa.getWycieczka().getSumaPunktow() - trasa.getSuma_punktow());
        }

        trasaService.createTrasa(trasa);

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/trasa/usun/{idTrasa}")
    public String usunTrase(@PathVariable int idTrasa,
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {

        Trasa trasa = trasaService.getOneById(idTrasa);
        if (trasa.getZrealizowana() != 0) {
            if (trasa.getDubel() == 0)
                trasa.getWycieczka()
                        .setSumaPunktow(trasa.getWycieczka().getSumaPunktow() - trasa.getSuma_punktow());
        }

        trasaService.removeTrasa(idTrasa);
        redirectAttributes.addFlashAttribute("success_msg", "Usunięto trasę.");

        return "redirect:" + request.getHeader("Referer");
    }

}
