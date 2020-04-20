package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdznakaServiceImpl;

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

import java.util.*;
import javax.servlet.http.HttpServletRequest;


@Controller
public class WycieczkaController {

    @Autowired
    private WycieczkaServiceImpl wycieczkaServiceImpl;
    

    @Autowired
    private OdznakaServiceImpl odznakaService;
    
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
		// tymczasowo aby jakas odznaka byla przypisana
		List<Odznaka> odznaki = odznakaService.getAllOdznaka();
		//
		model.addAttribute("odznaki", odznaki);
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("idKsiazeczka", idKsiazeczka);
        model.addAttribute("update", update);

        return "wycieczka/wycieczkaForm";
    }

    @PostMapping("/wycieczka/dodaj")
    public String createWycieczka(@ModelAttribute Wycieczka wycieczka,
								  RedirectAttributes redirectAttributes) {

        wycieczkaServiceImpl.createWycieczka(wycieczka);

		redirectAttributes.addFlashAttribute("success_msg", "Utworzono wycieczkę ✅");

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

		redirectAttributes.addFlashAttribute("success_msg", "Zaktualizowano wycieczkę ✅");

		return "redirect:/ksiazeczka/MojaKsiazeczka";
	}

	@GetMapping("/wycieczka/usun/{idWycieczka}")
	public String usunWycieczka(@PathVariable int idWycieczka,
								HttpServletRequest request,
								RedirectAttributes redirectAttributes){

    	wycieczkaServiceImpl.removeWycieczka(idWycieczka);

		redirectAttributes.addFlashAttribute("success_msg", "Usunięto wycieczkę ✅");

		return "redirect:" + request.getHeader("Referer");
	}
	
	@GetMapping("/wycieczka/zglos/{idWycieczka}")
	public String zglosWycieczka(@PathVariable int idWycieczka,
								HttpServletRequest request,
								RedirectAttributes redirectAttributes){

   Wycieczka wycieczkaUpdate = wycieczkaServiceImpl.getOneById(idWycieczka);
	wycieczkaUpdate.setOpis(wycieczkaUpdate.getOpis());
	wycieczkaUpdate.setDataOd(wycieczkaUpdate.getDataOd());
	wycieczkaUpdate.setDataDo(wycieczkaUpdate.getDataDo());
	wycieczkaUpdate.setSumaPunktow(wycieczkaUpdate.getSumaPunktow());
	wycieczkaUpdate.setZatwierdzona(wycieczkaUpdate.getZatwierdzona());
	wycieczkaUpdate.setZgloszona(1);
	
	wycieczkaServiceImpl.createWycieczka(wycieczkaUpdate);
    	

		redirectAttributes.addFlashAttribute("success_msg", "Zgłoszono wycieczkę do oceny ✅");

		return "redirect:" + request.getHeader("Referer");
	}
	
	@GetMapping("/wycieczka/zgloszone")
	public String getWycieczki(
								HttpServletRequest request,
								RedirectAttributes redirectAttributes,
								Model model,
								Authentication authentication					
			){
		 
	
		model.addAttribute("LoggedUser", authentication);
		model.addAttribute("wycieczki", wycieczkaServiceImpl.getAllWycieczkiByZgloszona(1));
		//return "redirect:" + request.getHeader("Referer");
        
        return "wycieczka/zgloszone";
	}
	
	@GetMapping("/wycieczka/akceptuj/{idWycieczka}")
	public String acceptWycieczka(
			@PathVariable int idWycieczka,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes)
	{
		int sumaPunktow = 0;
		int sumaPunktowKsiazeczki = 0;
		Wycieczka wycieczkaUpdate = wycieczkaServiceImpl.getOneById(idWycieczka);
		List<Trasa> trasa = wycieczkaUpdate.getTrasy();
		
		//Liczenie punktow z tras w wycieczce (Suma punktow do got)
		for(Trasa tr: trasa)
		{
			sumaPunktow += tr.getSumaPunktowDoGot();
			
		}
		wycieczkaUpdate.setSumaPunktowDoGot(sumaPunktow);
		
		
		// Akceptujac wycieczke zmieniamy jej status  na zrealizowana oraz jej tras a takze usuwamy ja z zgloszone wycieczki u przodownika
		
		wycieczkaUpdate.setZatwierdzona(1);
		wycieczkaUpdate.setZgloszona(0);
		//Dodanie do wycieczki sumy punktow z tras w wycieczce
		for(Trasa tr: trasa)
		{
			tr.setZrealizowana(1);
		}
		
		//Dodanie do ksiazeczki Punktow akceptowanej wycieczki
		sumaPunktowKsiazeczki = wycieczkaUpdate.getKsiazeczka().getSumaPunktow() + sumaPunktow;
		wycieczkaUpdate.getKsiazeczka().setSumaPunktow(sumaPunktowKsiazeczki);
		//Dodanie do turysty Punktow z ksiazeczki
		wycieczkaUpdate.getKsiazeczka().getTurysta().setPunkty(sumaPunktowKsiazeczki);
		wycieczkaServiceImpl.createWycieczka(wycieczkaUpdate);
		
		redirectAttributes.addFlashAttribute("success_msg", "Wycieczka została zaakceptowana ✅");
		
		return "redirect:" + request.getHeader("Referer");
	}
	@GetMapping("/wycieczka/odrzuc/{idWycieczka}")
	public String odrzucWycieczka(
			@PathVariable int idWycieczka,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes)
	{
		Wycieczka wycieczkaUpdate = wycieczkaServiceImpl.getOneById(idWycieczka);
		List<Trasa> trasa = wycieczkaUpdate.getTrasy();
		
		wycieczkaUpdate.setZatwierdzona(0);
		wycieczkaUpdate.setZgloszona(0);
		//Dodanie do wycieczki sumy punktow z tras w wycieczce
		for(Trasa tr: trasa)
		{
			tr.setZrealizowana(0);
		}
		
		wycieczkaServiceImpl.createWycieczka(wycieczkaUpdate);
		
		redirectAttributes.addFlashAttribute("success_msg", "Wycieczka została odrzucona ✅");
		return "redirect:" + request.getHeader("Referer");
	}
}
