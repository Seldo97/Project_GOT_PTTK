package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.*;
import grupa4.projektzespolowy.GOTTPKProjekt.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.servlet.http.HttpServletRequest;


@Controller
public class WycieczkaController {

    @Autowired
    private WycieczkaServiceImpl wycieczkaServiceImpl;

    @Autowired
    private OdznakaServiceImpl odznakaService;
    
    @Autowired
    private TurystaServiceImpl turystaService;

	@Autowired
	private KsiazeczkaServiceImpl ksiazeczkaService;

	@Autowired
	private TurystaOdznakaServiceImpl turystaOdznakaService;

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

    	Ksiazeczka ksiazeczka = ksiazeczkaService.getOneById(idKsiazeczka);
    	int idTurysta = ksiazeczka.getTurysta().getIdTurysta();

		List<TurystaOdznaka> odznakiTurysty = turystaOdznakaService.findByIdTurysta(idTurysta);
		Turysta turysta = turystaService.getOneById(idTurysta);

		//** DATA
		Date dataUrodzenia = (Date) turysta.getDataUrodzenia();
		LocalDate dataUr = dataUrodzenia.toLocalDate();
		LocalDate dzisiaj = LocalDate.now();
		//**

		boolean niepelnosprawnosc = turysta.isNiepelnosprawnosc();

//        List<Odznaka> odznakiTurystyFilter = odznakiTurysty
//                .stream()
//                .map(TurystaOdznaka::getOdznaka)
//                .collect(Collectors.toList());

		List<Odznaka> odznaki = new ArrayList<Odznaka>();


		if (dataUr.plusYears(7).compareTo(dzisiaj) > 0) {
			if (odznakiTurysty.size() == 0) {
				odznaki.add(odznakaService.getOneByNazwa("W góry - brązowa"));

			} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("W góry - brązowa", idTurysta))) {
				odznaki.add(odznakaService.getOneByNazwa("W góry - srebrna"));

			} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("W góry - srebrna", idTurysta))) {
				odznaki.add(odznakaService.getOneByNazwa("W góry - złota"));
			}
		} else {
			if (niepelnosprawnosc == true) {
				if (odznakiTurysty.size() == 0) {
					odznaki.add(odznakaService.getOneByNazwa("Popularna"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Popularna", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - brązowa"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Mała - brązowa", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - srebrna"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Mała - srebrna", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - złota"));
				}
			} else {
				if (odznakiTurysty.size() == 0) {
					odznaki.add(odznakaService.getOneByNazwa("Popularna"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Popularna", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - brązowa"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Mała - brązowa", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - srebrna"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Mała - srebrna", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Mała - złota"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Mała - złota", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Duża - brązowa"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Duża - brązowa", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Duża - srebrna"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Duża - srebrna", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Duża - złota"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Duża - złota", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Za wytrwałość - mała"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Za wytrwałość - mała", idTurysta))) {
					odznaki.add(odznakaService.getOneByNazwa("Za wytrwałość - duża"));
				} else if (odznakiTurysty.get(odznakiTurysty.size() - 1).equals(turystaOdznakaService.findOdznaka("Za wytrwałość - duża", idTurysta))) {
				}
			}
		}


		if (update != null) {
            Wycieczka wycieczka = wycieczkaServiceImpl.getOneById(idWycieczka);
			model.addAttribute("wycieczka", wycieczka);
        }
		// tymczasowo aby jakas odznaka byla przypisana
		//List<Odznaka> odznaki = odznakaService.getAllOdznaka();
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
	
		model.addAttribute("wycieczki", wycieczkaServiceImpl.getAllWycieczkiByZgloszona(1));
		
		
		//return "redirect:" + request.getHeader("Referer");
        
        return "wycieczka/zgloszone";
	}

}
