package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;

@RestController
public class UzytkownikController 
{
	 @Autowired
	    private UzytkownikService uzytkownikService;

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
}
