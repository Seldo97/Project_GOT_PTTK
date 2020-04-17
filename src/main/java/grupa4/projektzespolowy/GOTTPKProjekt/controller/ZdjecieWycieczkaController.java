package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Odznaka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;
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
	private WycieczkaServiceImpl WycieczkaServiceImpl;
	
	 @GetMapping("/zdjecia/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String getAllZdjeciaWycieczek(Model model, Authentication authentication, @PathVariable() Integer idWycieczka) 
	    {
	        model.addAttribute("LoggedUser", authentication);
	        model.addAttribute("idWycieczka", idWycieczka);
	        model.addAttribute("zdjecia", zdjecieWycieczkaServiceImpl.getAllZdjeciaByIdWycieczka(idWycieczka));
	        return "zdjeciaWycieczka/dokumentacja";
	    }
	 
		@GetMapping("/zdjecia/form/{idWycieczka}")
		public ModelAndView addformZdjecie(Authentication authentication, @PathVariable() Integer idWycieczka)
		{
			ModelAndView modelAndView = new ModelAndView("zdjeciaWycieczka/addZdjecia");
			modelAndView.addObject("idWycieczka", idWycieczka);
			modelAndView.addObject("LoggedUser", authentication);
			return modelAndView;
		}
	 
	 
	 @PostMapping("/zdjecie/dodaj/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String addZdjeciaDoWycieczki(Model model,@RequestParam("files") MultipartFile[] files, 
	    									Authentication authentication,@PathVariable() 
	    									Integer idWycieczka,
	    									@RequestParam(value="opis") String opis) throws IOException 
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
		 	
		 	
	        return "zdjeciaWycieczka/zdjecia";
	    }
}
