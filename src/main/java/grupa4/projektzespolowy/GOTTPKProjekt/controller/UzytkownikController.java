package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;

@RestController
public class UzytkownikController 
{
	 @Autowired
	    private UzytkownikService uzytkownikService;
	    
	 @Autowired
	    private RolaService rolaService;

	    private ModelAndView modelAndView;

	    @GetMapping("/uzytkownik")
	    public ModelAndView getAllProduct() {

	        ModelAndView modelAndView = new ModelAndView("uzytkownik");
	        modelAndView.addObject("uzytkownik", uzytkownikService.getAllUzytkownik());
	        //return ResponseEntity.ok().body(przodownikService.getAllProduct());
	        return modelAndView;
	    }

	    @PostMapping("/uzytkownik")
	    public ResponseEntity <Uzytkownik> createProduct(@RequestBody Uzytkownik uzytkownik) {
	        return ResponseEntity.ok().body(this.uzytkownikService.createUzytkownik(uzytkownik));
	    }
	    
	    @PostMapping("/uzytkownik/dodaj")
	    public void createTurysta(@RequestParam(value="login") String login,
	                              @RequestParam(value="haslo") String haslo,
	                              @RequestParam(value="email") String email,
	                              HttpServletResponse httpResponse ) throws IOException {
	    
	    	
	    	
	    	
	    }
	    
	    @PostMapping("/uzytkownik/update/{id_uzytkownik}")
	    public void updatePrzodownik(
	                                 @RequestParam(value="login") String login,
	                                 @RequestParam(value="haslo", required = false) String haslo,
	                                 @RequestParam(value="email") String email,
	                                 @RequestParam(value="id_rola") Integer id_rola,
	                                 @PathVariable Integer id_uzytkownik,
	                                 HttpServletResponse httpResponse ) throws IOException {

	        Uzytkownik uzytkownik = uzytkownikService.getOneById(id_uzytkownik);
	        uzytkownik.setLogin(login);
	        uzytkownik.setHaslo(haslo);
	        uzytkownik.setEmail(email);
	        
	      
	        httpResponse.sendRedirect("/");
	    }
}
