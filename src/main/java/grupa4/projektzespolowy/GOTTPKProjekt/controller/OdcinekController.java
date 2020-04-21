package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Punkt;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.OdcinekServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PasmoServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PunktServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Odcinek;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Pasmo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
public class OdcinekController
{
    @Autowired
    private OdcinekServiceImpl odcinekServiceImpl;
    @Autowired
    private GrupaServiceImpl grupaServiceImpl;
    @Autowired
    private PasmoServiceImpl pasmoServiceImpl;
    
    @Autowired
    private PunktServiceImpl punktServiceImpl;


    @GetMapping("/odcinki") // ścieżka na której zostanie obsłużona metoda
    public String getAllOdcinki(Model model, Authentication authentication)
    {

        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllOdcinki());

        return "odcinek/odcinki";
    }

    @GetMapping("/odcinkiWybor") // ścieżka na której zostanie obsłużona metoda
    public String getAllPasmoGrupa(Model model, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("grupy", grupaServiceImpl.getAllGrupa());
        model.addAttribute("pasma", pasmoServiceImpl.getAllPasmo());

        return "odcinek/odcinkiWybor";
    }

    @GetMapping("/odcinki/allGrupa/{idGrupa}") // ścieżka na której zostanie obsłużona metoda
    public String getAllGrupa(Model model, @PathVariable Integer idGrupa, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllByPasmo_Grupa_IdGrupa(idGrupa));

        return "odcinek/odcinki";
    }

    @GetMapping("/odcinki/allPasmo/{idPasmo}") // ścieżka na której zostanie obsłużona metoda
    public String getAllPasmo(Model model,@PathVariable Integer idPasmo, Authentication authentication)
    {


        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllByPasmo_IdPasmo(idPasmo));

        return "odcinek/odcinki";
    }
    
    @GetMapping({"/odcinki/form", "/odcinki/form/{idOdcinek}"})
    public String formTurystaOdznaka(Model model, @PathVariable(required = false) Integer idOdcinek) {


        if(idOdcinek != null){
           Odcinek odcinek = odcinekServiceImpl.getOneById(idOdcinek);
           List<Punkt> pun = punktServiceImpl.getAllPunkt();
           List<Pasmo> pasm = pasmoServiceImpl.getAllPasmo();
           model.addAttribute("pasma", pasm);
            model.addAttribute("odcinek", odcinek);
            model.addAttribute("punkty", pun);
            model.addAttribute("update", "1");  //???
        }
        List<Punkt> pun = punktServiceImpl.getAllPunkt();
        List<Pasmo> pasm = pasmoServiceImpl.getAllPasmo();
        model.addAttribute("punkty", pun);
        model.addAttribute("pasma", pasm);

        return "odcinek/odcinkiForm";
    }
    
    @PostMapping("/odcinki/dodaj") // ścieżka na której zostanie obsłużona metoda
    public String createOdcinek(Model model,@ModelAttribute Odcinek odcinek, Authentication authentication,RedirectAttributes redirectAttributes)
    {

    	odcinekServiceImpl.createOdcinek(odcinek); // puść inserta do bazy

         redirectAttributes.addFlashAttribute("success_msg", "Dodano wiersz pomyślnie!");

         return "redirect:/odcinki";
    }
    
    @PostMapping("/odcinki/update/{idOdcinek}") // ścieżka na której zostanie obsłużona metoda
    public String updateOdcinek(Model model,@PathVariable Integer idOdcinek,
    		@ModelAttribute Odcinek odcinek,
    		@RequestParam(value = "punktPoczatkowy") Integer punktPocz,
    		@RequestParam(value = "punktKoncowy") Integer punktKon,
    		Authentication authentication,
    		RedirectAttributes redirectAttributes)
    {
    	
    	if(idOdcinek != null)
  		{
    		Odcinek odcinekupdate = odcinekServiceImpl.getOneById(idOdcinek);
    		System.out.println(idOdcinek);
    		System.out.println(punktPocz);
        	System.out.println(punktKon);
    		odcinekupdate.setOtwarty(odcinek.getOtwarty());
    		odcinekupdate.setPasmo(odcinek.getPasmo());
    		odcinekupdate.setPunktPoczatkowy(punktServiceImpl.getOneById(punktPocz));
    		odcinekupdate.setPunktKoncowy(punktServiceImpl.getOneById(punktKon));
    		odcinekupdate.setPunktyDo(odcinek.getPunktyDo());
    		odcinekupdate.setPunktyOd(odcinek.getPunktyOd());
        	odcinekServiceImpl.createOdcinek(odcinekupdate);
  		}
    		
        model.addAttribute("LoggedUser", authentication);
        model.addAttribute("odcinki", odcinekServiceImpl.getAllByPasmo_IdPasmo(idOdcinek));
        
        redirectAttributes.addFlashAttribute("success_msg", "edytowano wiersz pomyślnie!");

        return "redirect:/odcinki";
    }
    
    @GetMapping("/odcinki/usun/{idOdcinek}")
    public String removeTurystaOdznaka(@PathVariable Integer idOdcinek,
                                       HttpServletRequest request,
                                       RedirectAttributes redirectAttributes) {

    	odcinekServiceImpl.removeOdcinek(idOdcinek);
    	
    	redirectAttributes.addFlashAttribute("success_msg", "Usunięto Odcinek!");

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }


}

