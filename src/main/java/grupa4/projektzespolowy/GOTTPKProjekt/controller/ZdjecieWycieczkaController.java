package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.WycieczkaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.ZdjecieWycieczkaServiceImpl;


@Controller
public class ZdjecieWycieczkaController 
{
	private  static String sciezkaZapisuZdjecNaDysku = "\\src\\main\\resources\\static\\images\\zdjeciaWycieczek";
	private  static String sciezkaZapisuZdjec = "\\images\\zdjeciaWycieczek";
	@Autowired
	private ZdjecieWycieczkaServiceImpl zdjecieWycieczkaServiceImpl;
	
	@Autowired
    private TrasaServiceImpl trasaService;
	
	@Autowired
	private WycieczkaServiceImpl WycieczkaServiceImpl;
	
	 @GetMapping("/zdjecia/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String getAllZdjeciaWycieczek(Model model, Authentication authentication, @PathVariable() Integer idWycieczka) 
	    {
	        model.addAttribute("LoggedUser", authentication);
	        model.addAttribute("idWycieczka", idWycieczka);
	        model.addAttribute("trasy", trasaService.getAllByIdWycieczka(idWycieczka));
	        model.addAttribute("zdjecia", zdjecieWycieczkaServiceImpl.getAllZdjeciaByIdWycieczka(idWycieczka));
	        return "zdjeciaWycieczka/dokumentacja";
	    }
	 
	 
	 @PostMapping("/zdjecie/dodaj/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String addZdjeciaDoWycieczki(Model model,@RequestParam("files") MultipartFile[] files, 
	    									Authentication authentication,@PathVariable() 
	    									Integer idWycieczka,
	    									@RequestParam(value="opis") String opis,
	    									 HttpServletRequest request,
	    									 RedirectAttributes redirectAttributes) throws IOException 
	    {
		 	
		 	//Zapisuje pliki do folderu static/images/zdjecieWycieczek
		 	StringBuilder sciezka = new StringBuilder();
		 	Wycieczka wycieczka =  WycieczkaServiceImpl.getOneById(idWycieczka);
		 	for(MultipartFile file : files)
		 	{
		 		
		 		Path fileNameAndPath = Paths.get(System.getProperty("user.dir")+sciezkaZapisuZdjecNaDysku, file.getOriginalFilename());
		 		sciezka.append(file.getOriginalFilename());
		 		Files.write(fileNameAndPath,file.getBytes());	
		 		
		 		ZdjecieWycieczka zdjecie =  new ZdjecieWycieczka();
			 	zdjecie.setOpis(opis);
			 	zdjecie.setSciezka(sciezkaZapisuZdjec.replace('\\', '/') + "/"+ file.getOriginalFilename() );
			 	zdjecie.setWycieczka(wycieczka);
			 	zdjecieWycieczkaServiceImpl.createZdjecie(zdjecie);
		 	}
		 	redirectAttributes.addFlashAttribute("success_msg", "Dodano zdjęcia.");
		 	return "redirect:" + request.getHeader("Referer");
	    }
	 
}
