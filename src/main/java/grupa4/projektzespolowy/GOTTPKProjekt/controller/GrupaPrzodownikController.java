package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.dto.PrzodownikDTO;
import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaPrzodownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Controller
public class GrupaPrzodownikController {

    @Autowired
    GrupaPrzodownikServiceImpl grupaPrzodownikService;
    @Autowired
    GrupaServiceImpl grupaService;
    @Autowired
    PrzodownikServiceImpl przodownikService;
    @Autowired
    UzytkownikServiceImpl uzytkownikService;

    @GetMapping("/wybierzPrzodownika")
    public String showPrzodownicy(){

        return "redirect:/przodownicy";
    }

    @GetMapping("/przodownicy/{idPrzodownik}/grupy")
    public String showGrupyPrzodownika(@PathVariable int idPrzodownik,
                                       Model model,
                                       Authentication authentication){

        List<GrupaPrzodownik> grupyPrzodownika = grupaPrzodownikService.getGrupyPrzodownika(idPrzodownik);
        PrzodownikDTO przodownik = przodownikService.getOneById(idPrzodownik);

        // Filtruje żeby nie pokazywało grup do których przodownik już jest przypisany
        List<Grupa> grupyPrzodownikaFilter = grupyPrzodownika
                .stream()
                .map(GrupaPrzodownik::getGrupa)
                .collect(Collectors.toList());
        List<Grupa> grupy = grupaService.getAllGrupa()
                .stream()
                .filter(not(grupyPrzodownikaFilter::contains))
                .collect(Collectors.toList());

        model.addAttribute("grupyPrzodownika", grupyPrzodownika);
        model.addAttribute("grupy", grupy);
        model.addAttribute("przodownik", przodownik);
        model.addAttribute("LoggedUser", authentication);

        return "przodownik/grupyPrzodownika";
    }

    @PostMapping("/grupaPrzodownik/przypiszGrupe")
    public String addGrupaToPrzodownik(@ModelAttribute GrupaPrzodownik grupaPrzodownik,
                                      HttpServletRequest request,
                                      RedirectAttributes redirectAttributes){

        String referer = request.getHeader("Referer");

        grupaPrzodownikService.saveGrupaPrzodownik(grupaPrzodownik);
        redirectAttributes.addFlashAttribute("success_msg", "Przydzielono grupę przodownikowi!");

        return "redirect:" + referer;
    }

    @GetMapping("/grupaPrzodownik/usun/{idGrupaPrzodownik}")
    public String removeTurystaOdznaka(@PathVariable Integer idGrupaPrzodownik,
                                       HttpServletRequest request) {

        grupaPrzodownikService.removeGrupaPrzodownik(idGrupaPrzodownik);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @GetMapping("/grupy/{idGrupa}/przodownicy")
    public String showPrzodownicyGrupy(@PathVariable int idGrupa,
                                       Model model,
                                       Authentication authentication){

        List<GrupaPrzodownik> przodownicyGrupy = grupaPrzodownikService.getPrzodownicyGrupy(idGrupa);
        Grupa grupa = grupaService.getOneById(idGrupa);

        model.addAttribute("przodownicyGrupy", przodownicyGrupy);
        model.addAttribute("grupa", grupa);
        model.addAttribute("LoggedUser", authentication);

        return "grupy/przodownicyGrup";
    }

    @GetMapping("/mojeGrupy")
    public String showMyGroups(Model model,
                               Authentication authentication){

        Uzytkownik uzytkownik = uzytkownikService.getLoggedUserDetails(authentication);

        List<GrupaPrzodownik> grupyPrzodownika = grupaPrzodownikService.getGrupyPrzodownika(uzytkownik.getPrzodownik().getIdPrzodownik());
        PrzodownikDTO przodownik = przodownikService.getOneById(uzytkownik.getPrzodownik().getIdPrzodownik());

        model.addAttribute("grupyPrzodownika", grupyPrzodownika);
        model.addAttribute("przodownik", przodownik);
        model.addAttribute("LoggedUser", authentication);

        return "przodownik/grupyPrzodownika";
    }

}
