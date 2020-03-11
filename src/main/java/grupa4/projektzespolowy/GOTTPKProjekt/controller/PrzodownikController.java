package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PrzodownikController {
    @Autowired
    private PrzodownikService przodownikService;
    @Autowired
    private UzytkownikService uzytkownikService;

    private ModelAndView modelAndView;

    @GetMapping("/przodownicy")
    public ModelAndView getAllPrzodownik() {

        modelAndView = new ModelAndView("przodownik/przodownicy");
        modelAndView.addObject("przodownicy", przodownikService.getAllPrzodownik());

        return modelAndView;
    }

    @PostMapping("/przodownicy/dodaj")
    public void createProduct(@RequestParam(value="imie") String imie,
                              @RequestParam(value="nazwisko") String nazwisko,
                              @RequestParam(value="telefon") String telefon,
                              @RequestParam(value="login") String login,
                              @RequestParam(value="haslo") String haslo,
                              @RequestParam(value="email") String email,
                              HttpServletResponse httpResponse,
                              RedirectAttributes redirectAttributes) throws IOException {

        Przodownik przodownik = new Przodownik(imie, nazwisko, telefon, new Uzytkownik(login, haslo, email));
        przodownikService.createPrzodownik(przodownik);

        redirectAttributes.addFlashAttribute("WIADOMOSC", "wiadomosc");
        httpResponse.sendRedirect("/przodownicy");
    }
}
