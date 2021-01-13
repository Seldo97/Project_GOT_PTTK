package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Grupa;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GrupaController {


    @Autowired
    private GrupaServiceImpl grupaServiceImpl;


    @GetMapping("/grupy")
    public ModelAndView getAllProduct( Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("grupy/grupy");
        modelAndView.addObject("grupy", grupaServiceImpl.getAllGrupa());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }
    
    @GetMapping("/grupy/addForm")
	public ModelAndView addFormGrupa(Authentication authentication)
	{
		ModelAndView modelAndView = new ModelAndView("grupy/addForm");
		modelAndView.addObject("LoggedUser", authentication);
		return modelAndView;
	}
    
    @GetMapping("/grupy/updateForm")
   	public String updateFormGrupa(Model model,
   											Authentication authentication, 
   											@RequestParam(value = "id", required = false) Integer idGrupa)
   	{
   		ModelAndView modelAndView = new ModelAndView("grupy/updateForm");
   		
   		if(idGrupa != null)
   		{
            Grupa grupa = grupaServiceImpl.getOneById(idGrupa);
            model.addAttribute("grupa", grupa);
   		}
   		modelAndView.addObject("LoggedUser", authentication);
   		return "/grupy/updateForm";
   	}
    
    @PostMapping("/grupy/dodaj")
    public String addGrupa(@ModelAttribute Grupa grupa,
                                      HttpServletRequest request,
                                      RedirectAttributes redirectAttributes)
    {

    	grupaServiceImpl.createGrupa(grupa);
        redirectAttributes.addFlashAttribute("success_msg", "Przydzielono odznake turyście!");

        return "redirect:/grupy";
    }
    
    @PostMapping("/grupy/update/{idGrupa}")
    public String updateGrupa(@RequestParam(value="nazwa") String nazwa,
                                 @PathVariable Integer idGrupa) {

        Grupa grupa = grupaServiceImpl.getOneById(idGrupa);

        grupa.setNazwa(nazwa);
       
        grupaServiceImpl.createGrupa(grupa);

        return "redirect:/grupy";
    }
    
    @GetMapping("/grupy/usun/{idGrupa}")
    public String usunGrupa(@PathVariable Integer idGrupa,
    						HttpServletRequest request,
    						RedirectAttributes redirectAttributes) 
    {

        Grupa grupa = grupaServiceImpl.getOneById(idGrupa);

        grupaServiceImpl.deleteGrupa(grupa.getIdGrupa());
        
        redirectAttributes.addFlashAttribute("success_msg", "usunieto grupę pomyślnie!");

        return "redirect:/grupy";
    }

    @GetMapping("/grupyFRONT")
    public ModelAndView getAllGrupyFront( Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("grupy/grupyFRONT");
        modelAndView.addObject("grupy", grupaServiceImpl.getAllGrupa());
        modelAndView.addObject("LoggedUser", authentication);

        return modelAndView;
    }


}
