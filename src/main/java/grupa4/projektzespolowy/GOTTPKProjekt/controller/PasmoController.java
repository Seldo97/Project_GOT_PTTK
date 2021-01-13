package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PasmoServiceImpl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasmoController {

    @Autowired
    private PasmoServiceImpl pasmoServiceImpl;
    
    @Autowired
    private GrupaServiceImpl grupaServiceImpl;


    @GetMapping("/pasma")
    public ModelAndView getAllProduct(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("pasma/pasma");
        modelAndView.addObject("pasma", pasmoServiceImpl.getAllPasmo());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }
    
    @GetMapping("/pasma/addForm")
   	public ModelAndView addFormPasmo(Authentication authentication)
   	{
   		ModelAndView modelAndView = new ModelAndView("pasma/addForm");
   		modelAndView.addObject("LoggedUser", authentication);
   		modelAndView.addObject("grupy", grupaServiceImpl.getAllGrupa());
   		return modelAndView;
   	}
    
    @GetMapping("/pasma/updateForm")
    public String updateformPasmo(Model model,
                                 @RequestParam(value = "id") Integer idPasmo,
                                 Authentication authentication) {
        model.addAttribute("LoggedUser", authentication);

        if(idPasmo != null){
            Pasmo pasmo = pasmoServiceImpl.getOneById(idPasmo);
            Grupa grupa = pasmo.getGrupa();
            model.addAttribute("pasmo", pasmo);
            model.addAttribute("grupa", grupa);
            model.addAttribute("grupy", grupaServiceImpl.getAllGrupa());
        }

        return "pasma/updateForm";
    }
    
       
       @PostMapping("/pasma/update/{idPasmo}")
      	public String updatePasmo(@RequestParam(value = "nazwaPasmo") String nazwaPasmo,
  				 						@RequestParam(value = "selectGrupa") Integer idGrupa,
  				 						@PathVariable Integer idPasmo)
      	{
      		if(idPasmo != null)
      		{
               Pasmo pasmo = pasmoServiceImpl.getOneById(idPasmo);
               pasmo.setNazwa(nazwaPasmo);
               pasmo.setGrupa(grupaServiceImpl.getOneById(idGrupa));
               
               pasmoServiceImpl.createPasmo(pasmo);
      		}
      		 return "redirect:/pasma";
      	}
       
       @PostMapping("/pasma/dodaj")
       public String addPasmo(@RequestParam(value = "nazwaPasmo") String nazwaPasmo,
    		   				 @RequestParam(value = "selectGrupa") Integer idGrupa,
                                         HttpServletRequest request,
                                         RedirectAttributes redirectAttributes)
       {
    	   Grupa grupa = grupaServiceImpl.getOneById(idGrupa);
    	   Pasmo pasmo = new Pasmo(nazwaPasmo,grupa);
    	   pasmoServiceImpl.createPasmo(pasmo);
           redirectAttributes.addFlashAttribute("success_msg", "Dodano Pasmo!");

           return "redirect:/pasma";
       }
       
       @GetMapping("/pasma/usun/{idPasmo}") // usuń turyste wraz z jego kontem użytkownika
   	public String removePasmo(@PathVariable Integer idPasmo,
   								RedirectAttributes redirectAttributes) throws IOException {

   		pasmoServiceImpl.getOneById(idPasmo);  
   		pasmoServiceImpl.removePasmo(idPasmo);
   		
   		redirectAttributes.addFlashAttribute("success_msg", "Usunięto pasmo pomyślnie");
   		return "redirect:/pasma";
   	}

    @GetMapping("/pasmaGrupy/{idGrupa}")
    public ModelAndView getAllPasmoForGrupa(@PathVariable int idGrupa, Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("pasma/pasmaGrupy");
        modelAndView.addObject("pasma", pasmoServiceImpl.getAllPasmoByIdGrupa(idGrupa));
        modelAndView.addObject("idGrupa", idGrupa);
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }
}
