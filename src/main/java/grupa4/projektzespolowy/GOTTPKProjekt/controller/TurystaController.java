package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaServiceImpl;

@Controller
public class TurystaController 
{
	@Autowired
	private TurystaServiceImpl turystaServiceImpl;
	
	@Autowired
	private UzytkownikServiceImpl uzytkownikServiceImpl;
	
	@Autowired
	private RolaService rolaService;
	
	@GetMapping("/turysci")
    public ModelAndView getAllProduct() {

        ModelAndView modelAndView = new ModelAndView("turysta/turysta");
        modelAndView.addObject("turysci", turystaServiceImpl.getAllTurysta());
        return modelAndView;
    }
	
	 
	  @GetMapping("/turysta/addForm")
	    public ModelAndView addformTurysta() 
	  	{

	        ModelAndView modelAndView = new ModelAndView("turysta/addForm");
	        return modelAndView;
	    }
	  
	  @GetMapping("/turysta/updateForm/{id_turysta}")
	    public ModelAndView updateformTurysta(@PathVariable(required = true) Integer id_turysta) 
	  	{
	        ModelAndView modelAndView = new ModelAndView("turysta/updateForm");
	        if(id_turysta != null)
	        {
	           Turysta turysta = turystaServiceImpl.getOneById(id_turysta);
	           Uzytkownik uzytkownik = turysta.getUzytkownik();
	            modelAndView.addObject("turysta", turysta);
	            modelAndView.addObject("uzytkownik", uzytkownik);
	        }
	        return modelAndView;
	    }
	 
	  @PostMapping("/turysta/dodaj")
	    public String createTurysta(@RequestParam(value="imie") String imie,
	                                  @RequestParam(value="nazwisko") String nazwisko,
	                                  @RequestParam(value="opis") String opis,
	                                  @RequestParam(value="punkty") int punkty,
	                                  @RequestParam(value="telefon") String telefon,
	                                  @RequestParam(value="login") String login,
	                                  @RequestParam(value="haslo") String haslo,
	                                  @RequestParam(value="email") String email,
	                                  RedirectAttributes redirectAttributes ) throws IOException {

	        Rola rola = rolaService.getOneByName("Turysta");
	        Uzytkownik uzytkownik = new Uzytkownik(login, haslo, email,rola); // tworze użytkownika z referencją do pobranej roli
	        rola.getUzytkownicy().add(uzytkownik); // dodaj użytkownika do roli (relacja jeden do wielu)
	        Turysta turysta = new Turysta(imie, nazwisko,opis,uzytkownik,telefon,punkty); // stwórz turyste z utworzonym użytkownikiem

	        turystaServiceImpl.createTurysta(turysta); // puść inserta do bazy
	        // UWAGA! kolejność operacji jest ważna.


	        redirectAttributes.addFlashAttribute("wiadomosc", "Dodane turyste pomyślnie");
	        return "redirect:/turysci";
	    }
	  
	   @PostMapping("/turysta/update/{id_turysta}")
	    public String updateTurysta(@RequestParam(value="imie") String imie,
	                                 @RequestParam(value="nazwisko") String nazwisko,
	                                 @RequestParam(value="telefon") String telefon,
	                                 @RequestParam(value="login") String login,
	                                 @RequestParam(value="haslo", required = false) String haslo,
	                                 @RequestParam(value="email") String email,
	                                 @PathVariable Integer id_turysta,
	                                 RedirectAttributes redirectAttributes) throws IOException {

	        Turysta turysta = turystaServiceImpl.getOneById(id_turysta);
	        
	        turysta.setImie(imie);
	        turysta.setNazwisko(nazwisko);
	        turysta.setTelefon(telefon);
	        turysta.getUzytkownik().setLogin(login);
	        turysta.getUzytkownik().setHaslo(haslo);
	        turysta.getUzytkownik().setEmail(email);

	       turystaServiceImpl.createTurysta(turysta);
	       redirectAttributes.addFlashAttribute("wiadomosc", "Zmiany zostały przyjęte pomyślnie");
	       return "redirect:/turysci";
    }
	   
	   @GetMapping("/turysta/usun/{id_turysta}") // usuń turyste wraz z jego kontem użytkownika
	    public String removeTurysta(@PathVariable Integer id_turysta,
	    								RedirectAttributes redirectAttributes) throws IOException {

	        Turysta turysta = turystaServiceImpl.getOneById(id_turysta); // pobieram turyste po odebranym id
	        Uzytkownik uzytkownik = turysta.getUzytkownik(); // pobieram uzytkownika przypisanego do turysty
	        turysta.setUzytkownik(null); // usuwam referencje do rodzica

	        uzytkownikServiceImpl.removeUzytkownik(uzytkownik.getIdUzytkownik()); // usuwam użytkownika i od razu kaskadowo usuwa się turysta.
	        redirectAttributes.addFlashAttribute("wiadomosc", "Usunięto turyste pomyślnie");
	        return "redirect:/turysci";
	    }
	
}
