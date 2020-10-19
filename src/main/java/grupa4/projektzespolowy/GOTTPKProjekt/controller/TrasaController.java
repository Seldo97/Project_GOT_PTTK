package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.TrasaOdcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaOdcinekServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @Autowired
    private TrasaOdcinekServiceImpl trasaOdcinekService;

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
            trasa.getWycieczka().setSumaPunktow(trasa.getWycieczka().getSumaPunktow() + trasa.getSuma_punktow());
            trasa.getWycieczka().setSumaPunktowDoGot(trasa.getWycieczka().getSumaPunktowDoGot() + trasa.getSumaPunktowDoGot());

        } else {
            trasa.setZrealizowana(0);
            trasa.getWycieczka().setSumaPunktow(trasa.getWycieczka().getSumaPunktow() - trasa.getSuma_punktow());
            trasa.getWycieczka().setSumaPunktowDoGot(trasa.getWycieczka().getSumaPunktowDoGot() - trasa.getSumaPunktowDoGot());
        }

        trasaService.createTrasa(trasa);

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/trasa/usun/{idTrasa}")
    public String usunTrase(@PathVariable int idTrasa,
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {

        List<TrasaOdcinek> odcinkiUsuwanejTrasy = trasaOdcinekService.getAllOdcinkiByIdTrasa(idTrasa);

        for (TrasaOdcinek out : odcinkiUsuwanejTrasy) {

            TrasaOdcinek trasaOdcinek = out;

            trasaOdcinek.getTrasa().setSuma_punktow(trasaOdcinek.getTrasa().getSuma_punktow() - trasaOdcinek.getPunkty());
            if (trasaOdcinek.getDubel() == 0)
                trasaOdcinek.getTrasa().setSumaPunktowDoGot(trasaOdcinek.getTrasa().getSumaPunktowDoGot() - trasaOdcinek.getPunkty());

            List<TrasaOdcinek> dubleOdcinkow = trasaOdcinekService.getAllByOdcinekAndOdznaka(trasaOdcinek.getOdcinek(), trasaOdcinek.getTrasa().getWycieczka().getOdznaka());
            int wystapienTejTrasy = (trasaOdcinekService.getAllByOdcinekAndOdznaka(trasaOdcinek.getOdcinek(), trasaOdcinek.getTrasa().getWycieczka().getOdznaka())).size();
            System.out.println("Po usunieciu: " + (wystapienTejTrasy - 1));
            if (wystapienTejTrasy - 1 <= 2) {
                //trasaOdcinek.getTrasa().setDubel(0);
                trasaOdcinek.setDubel(0);
                for (TrasaOdcinek ts : dubleOdcinkow) {
                    if (ts.getDubel() == 1) {
                        ts.getTrasa().setSumaPunktowDoGot(ts.getTrasa().getSumaPunktowDoGot() + ts.getPunkty());
                    }
                    ts.setDubel(0);
                    ts.getTrasa().setDubel(0);
                }
                System.out.println("Wchodze w petle i dubel = 0: " + trasaOdcinek.getTrasa().getDubel());
            }

            List<TrasaOdcinek> odcinkiTrasy = trasaOdcinekService.getAllOdcinkiByIdTrasa(trasaOdcinek.getTrasa().getIdTrasa());
            boolean flagaDubli = false;
            for (TrasaOdcinek ot : odcinkiTrasy) {
                if (ot.getDubel() == 1) {
                    flagaDubli = true;
                    break;
                }
            }
            if (!flagaDubli)
                trasaOdcinek.getTrasa().setDubel(0);

            //trasaOdcinek.getTrasa().setSuma_punktow(trasaOdcinek.getTrasa().getSuma_punktow() - trasaOdcinek.getPunkty());

            trasaOdcinekService.removeTrasaOdcinekById(out.getIdTrasaOdcinek());
        }

        trasaService.removeTrasa(idTrasa);
        redirectAttributes.addFlashAttribute("success_msg", "Usunięto trasę.");

        return "redirect:" + request.getHeader("Referer");
    }
    
    @GetMapping("/trasa/szczegoly/{idTrasa}")
    public String szczegolyTrasy(@PathVariable int idTrasa,
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes,
                            Model model,
                            Authentication authentication ) 
    {

        Trasa trasa = trasaService.getOneById(idTrasa);
        List<TrasaOdcinek> listaOdcinkow = trasaOdcinekService.getAllOdcinkiByTrasa(trasa);
        
        model.addAttribute("trasy", trasa);
        model.addAttribute("odcinki", listaOdcinkow);
        model.addAttribute("LoggedUser", authentication);
        
       
        //return "redirect:" + request.getHeader("Referer");
        return "trasa/szczegoly";
    }
    
    @GetMapping("/trasa/akceptuj/{idTrasa}")
    public String akceptujTrase(@PathVariable int idTrasa,
                                 HttpServletRequest request,
                                 RedirectAttributes redirectAttributes) {
    	
        Trasa trasa = trasaService.getOneById(idTrasa);
        trasa.setSprawdzona(1);
        trasaService.createTrasa(trasa);
        
        redirectAttributes.addFlashAttribute("success_msg", "Status trasy uległ zmianie ✅");

        return "redirect:" + request.getHeader("Referer");
    }
    
    @GetMapping("/trasa/odrzuc/{idTrasa}")
    public String odrzucTrase(@PathVariable int idTrasa,
                                 HttpServletRequest request,
                                 RedirectAttributes redirectAttributes) {

        Trasa trasa = trasaService.getOneById(idTrasa);
         trasa.setSprawdzona(0);
        trasaService.createTrasa(trasa);
        
        Wycieczka wycieczka = trasa.getWycieczka();
        wycieczka.setZgloszona(0);
        wycieczkaService.createWycieczka(wycieczka);
        
        redirectAttributes.addFlashAttribute("success_msg", "Status trasy i wycieczki uległ zmianie ✅");

        return "redirect:" + request.getHeader("Referer");
    }

}
