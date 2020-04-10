package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Ksiazeczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
public class WycieczkaController {

    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private WycieczkaServiceImpl wycieczkaServiceImpl;

    @GetMapping("/wycieczki") // ścieżka na której zostanie obsłużona metoda
    public String getAllZdjeciaWycieczek(Model model, Authentication authentication) {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("wycieczki", wycieczkaServiceImpl.getAllWycieczki());

        return "wycieczka/wycieczka";
    }

    @GetMapping({"/wycieczka/form/{idKsiazeczka}", "/wycieczka/form/{idKsiazeczka}/{idWycieczka}/{update}"})
    public String createWycieczkaForm(@PathVariable Integer idKsiazeczka,
                                      @PathVariable(required = false) Integer update,
                                      @PathVariable(required = false) Integer idWycieczka,
                                      Model model,
                                      Authentication authentication) {

        if (update != null) {
            Wycieczka wycieczka = wycieczkaServiceImpl.getOneById(idWycieczka);
			model.addAttribute("wycieczka", wycieczka);
        }

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("idKsiazeczka", idKsiazeczka);
        model.addAttribute("update", update);

        return "wycieczka/wycieczkaForm";
    }

    @PostMapping("/wycieczka/dodaj")
    public String createWycieczka(@ModelAttribute Wycieczka wycieczka,
								  RedirectAttributes redirectAttributes) {

        wycieczkaServiceImpl.createWycieczka(wycieczka);

		redirectAttributes.addFlashAttribute("success_msg", "Utworzono wycieczkę");

        return "redirect:/ksiazeczka/MojaKsiazeczka";
    }

	@PostMapping("/wycieczka/update/{idWycieczka}")
	public String updateWycieczka(@ModelAttribute Wycieczka wycieczka,
								  @PathVariable Integer idWycieczka,
								  RedirectAttributes redirectAttributes) {

    	Wycieczka wycieczkaUpdate = wycieczkaServiceImpl.getOneById(idWycieczka);
    	wycieczkaUpdate.setOpis(wycieczka.getOpis());
    	wycieczkaUpdate.setDataOd(wycieczka.getDataOd());
    	wycieczkaUpdate.setDataDo(wycieczka.getDataDo());
    	wycieczkaUpdate.setSumaPunktow(wycieczka.getSumaPunktow());
    	wycieczkaUpdate.setZatwierdzona(wycieczka.getZatwierdzona());

		wycieczkaServiceImpl.createWycieczka(wycieczkaUpdate);

		redirectAttributes.addFlashAttribute("success_msg", "Zaktualizowano wycieczkę");

		return "redirect:/ksiazeczka/MojaKsiazeczka";
	}

	@GetMapping("/wycieczka/usun/{idWycieczka}")
	public String usunWycieczka(@PathVariable int idWycieczka,
								HttpServletRequest request,
								RedirectAttributes redirectAttributes){

    	wycieczkaServiceImpl.removeWycieczka(idWycieczka);

		redirectAttributes.addFlashAttribute("success_msg", "Usunięto wycieczkę");

		return "redirect:" + request.getHeader("Referer");
	}


}
