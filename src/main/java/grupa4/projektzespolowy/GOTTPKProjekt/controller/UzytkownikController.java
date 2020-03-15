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

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;


@RestController
public class UzytkownikController 
{
	 @Autowired
	    private UzytkownikServiceImpl uzytkownikServiceImpl;
	    @Autowired
	    private RolaServiceImpl rolaServiceImpl;

	    private ModelAndView modelAndView;

	    @GetMapping("/uzytkownicy")
	    public ModelAndView getAllProduct() {

	        ModelAndView modelAndView = new ModelAndView("uzytkownik/uzytkownik");
	        modelAndView.addObject("uzytkownicy", uzytkownikServiceImpl.getAllUzytkownik());
	        return modelAndView;
	    }

	    @PostMapping("/uzytkownik")
	    public ResponseEntity <Uzytkownik> createProduct(@RequestBody Uzytkownik uzytkownik) {
	        return ResponseEntity.ok().body(this.uzytkownikServiceImpl.createUzytkownik(uzytkownik));
	    }
	    
	    @GetMapping("/uzytkownik/addForm")
	    public ModelAndView addformUzytkownik() 
	  	{

	        ModelAndView modelAndView = new ModelAndView("turysta/addForm");
	        return modelAndView;
	    }
	    
}
