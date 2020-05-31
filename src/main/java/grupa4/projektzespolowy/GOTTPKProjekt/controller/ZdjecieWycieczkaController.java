package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

import grupa4.projektzespolowy.GOTTPKProjekt.model.GrupaPrzodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Trasa;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Turysta;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Wycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.model.ZdjecieWycieczka;
import grupa4.projektzespolowy.GOTTPKProjekt.service.GrupaPrzodownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.TrasaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
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
	
	@Autowired
	private UzytkownikServiceImpl uzytkownikServiceImpl;
	
	@Autowired
	private GrupaPrzodownikServiceImpl grupaPrzodownikService;
	
	 @GetMapping("/zdjecia/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String getAllZdjeciaWycieczek(Model model, Authentication authentication, @PathVariable() Integer idWycieczka) 
	    {
		 List<GrupaPrzodownik> grupyPrzodownika = null;
		 List<GrupaPrzodownik> grupyPrzodownikaPasujace = new ArrayList<>();
		 List<GrupaPrzodownik> grupyPrzodownikatmp = new ArrayList<>();
		 List<GrupaPrzodownik> grupyPrzodownikaNiePasujace = new ArrayList<>();
		 Uzytkownik uzytkownik =  uzytkownikServiceImpl.getLoggedUserDetails(authentication);
		 Wycieczka wycieczka = WycieczkaServiceImpl.getOneById(idWycieczka);
		 List<Trasa> tr = trasaService.getAllByIdWycieczka(idWycieczka);
		 Turysta turysta = wycieczka.getKsiazeczka().getTurysta();
		 if((uzytkownik.getPrzodownik() != null))
		 {
			 Przodownik przodownik = uzytkownik.getPrzodownik();
			  grupyPrzodownika = grupaPrzodownikService.getGrupyPrzodownika(przodownik.getIdPrzodownik());
			  
			 for(Trasa trasa: tr)
			 {
				 for(GrupaPrzodownik gr: grupyPrzodownika)
				 {
					 
					 if(trasa.getPasmo().getGrupa().getNazwa().equals(gr.getGrupa().getNazwa()))
							 {
						 		if(grupyPrzodownikatmp.contains(gr))
						 		{
						 			continue;
						 		}
						 		else
						 		{
						 			grupyPrzodownikatmp.add(gr);
						 		}
							 }
					 
					 /*
					 if(trasa.getPasmo().getGrupa().getNazwa().contains(gr.getGrupa().getNazwa()))
					{
						 if(grupyPrzodownikaPasujace.contains(gr))
						 {
							 continue;
						 }
						 else
						 {
							 grupyPrzodownikaPasujace.add(gr);
						 }
					}
					 else if(trasa.getPasmo().getGrupa().getNazwa() != gr.getGrupa().getNazwa())
					 {
						 if(grupyPrzodownikaNiePasujace.contains(gr))
						 {
							 continue;
						 }
						 else
						 {
							 grupyPrzodownikaNiePasujace.add(gr);
						 }	 
						
					 }
					   */
				 }
				  
				
			 }
			
		 }
		
		 
		
	        model.addAttribute("LoggedUser", authentication);
	        model.addAttribute("idWycieczka", idWycieczka);
	        model.addAttribute("wycieczka", wycieczka);
	        model.addAttribute("turysta", turysta);
	        model.addAttribute("grupyPrzodownika", grupyPrzodownikatmp);
	        model.addAttribute("grupyPrzodownikaPasujace", grupyPrzodownikaPasujace);
	        model.addAttribute("grupyPrzodownikaNiePasujace", grupyPrzodownikaNiePasujace);
	      
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
	 
	 @GetMapping("/zdjecie/usunWszystkie/{idWycieczka}") // ścieżka na której zostanie obsłużona metoda
	    public String deleteAllZdjeciaDoWycieczki(Authentication authentication,
	    									@PathVariable() Integer idWycieczka,
	    									 HttpServletRequest request,
	    									 RedirectAttributes redirectAttributes) throws IOException 
	    
	    {
		 	Wycieczka wycieczka = WycieczkaServiceImpl.getOneById(idWycieczka);
		 	List<ZdjecieWycieczka> zdjecia = zdjecieWycieczkaServiceImpl.getAllZdjeciaByIdWycieczka(idWycieczka);
		 	
		 	String[] tmp;
		 	String nazwaPliku;
		 	for(ZdjecieWycieczka zdj: zdjecia)
		 	{
		 		tmp = zdj.getSciezka().split("/");
		 		nazwaPliku = tmp[3];
		 		Path imagesPath = Paths.get(System.getProperty("user.dir") + sciezkaZapisuZdjecNaDysku + "\\" + nazwaPliku);
		 		try {
			 	    Files.delete(imagesPath);
			 	    System.out.println("File "
			 	            + imagesPath.toAbsolutePath().toString()
			 	            + " successfully removed");
			 	} catch (IOException e) {
			 	    System.err.println("Unable to delete "
			 	            + imagesPath.toAbsolutePath().toString()
			 	            + " due to...");
			 	    e.printStackTrace();
			 	}
		 	}
		 	
		 	zdjecieWycieczkaServiceImpl.deleteAllByWycieczka(wycieczka);
		 	
		 	redirectAttributes.addFlashAttribute("success_msg", "Usunieto zdjecia zdjęcia.");
		 	return "redirect:" + request.getHeader("Referer");
	    }
	 
	 @GetMapping("/zdjecie/usunZaznaczone") // ścieżka na której zostanie obsłużona metoda
	    public String deleteZaznaczoneZdjeciaDoWycieczki(Authentication authentication,
	    										@RequestParam(value="imageIds", required = false) Integer[] idZdjecia,
	    									 HttpServletRequest request,
	    									 RedirectAttributes redirectAttributes) throws IOException 
	    {
		 
		 if(idZdjecia != null)
		 {
			 List<ZdjecieWycieczka> zdjecia = new ArrayList<ZdjecieWycieczka>();
			 ZdjecieWycieczka dajZdjecie;
			 for(Integer id: idZdjecia)
			 {
				 dajZdjecie =  zdjecieWycieczkaServiceImpl.getOneById(id);
				 zdjecia.add(dajZdjecie);
				 
					String[] tmp;
				 	String nazwaPliku;
				 	for(ZdjecieWycieczka zdj: zdjecia)
				 	{
				 		tmp = zdj.getSciezka().split("/");
				 		nazwaPliku = tmp[3];
				 		Path imagesPath = Paths.get(System.getProperty("user.dir") + sciezkaZapisuZdjecNaDysku + "\\" + nazwaPliku);
				 		try {
					 	    Files.delete(imagesPath);
					 	    System.out.println("File "
					 	            + imagesPath.toAbsolutePath().toString()
					 	            + " successfully removed");
					 	} catch (IOException e) {
					 	    System.err.println("Unable to delete "
					 	            + imagesPath.toAbsolutePath().toString()
					 	            + " due to...");
					 	    e.printStackTrace();
					 	}
				 	}
				zdjecieWycieczkaServiceImpl.removeZdjecie(id);
			 }

			 	redirectAttributes.addFlashAttribute("success_msg", "Usunięto zdjęcie.");
		 }
		 else
		 {
			 redirectAttributes.addFlashAttribute("error_msg", "Nie udało się usunąć zdjęcia/zdjęć czy wybrałeś zdjęcie ?");
		 }
		 	return "redirect:" + request.getHeader("Referer");
	    }
}
