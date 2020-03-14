package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TurystaServiceImpl;

@RestController
public class TurystaController 
{
	@Autowired
	private TurystaServiceImpl turystaServiceImpl;
	
	@GetMapping("/turysta")
    public ModelAndView getAllProduct() {

        ModelAndView modelAndView = new ModelAndView("turysta");
        modelAndView.addObject("turysta", turystaServiceImpl.getAllTurysta());
        return modelAndView;
    }
	
	 @PostMapping("/turysta")
	    public ResponseEntity <Turysta> createProduct(@RequestBody Turysta turysta) {
	        return ResponseEntity.ok().body(this.turystaServiceImpl.createTurysta(turysta));
	    }
	
}
