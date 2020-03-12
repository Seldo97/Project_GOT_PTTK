package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaService;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class PrzodownikController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private PrzodownikService przodownikService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private RolaService rolaService;

    private ModelAndView modelAndView;

    @GetMapping("/przodownicy") // ścieżka na której zostanie obsłużona metoda
    public ModelAndView getAllPrzodownik() {

        modelAndView = new ModelAndView("przodownik/przodownicy"); // ścieżka do pliku twig który ma zostać wyrenderowany
        modelAndView.addObject("przodownicy", przodownikService.getAllPrzodownik()); // dodanie zmiennych do twiga

        return modelAndView;
    }

    @PostMapping("/przodownicy/dodaj")
    public void createPrzodownik(@RequestParam(value="imie") String imie,
                                  @RequestParam(value="nazwisko") String nazwisko,
                                  @RequestParam(value="telefon") String telefon,
                                  @RequestParam(value="login") String login,
                                  @RequestParam(value="haslo") String haslo,
                                  @RequestParam(value="email") String email,
                                  HttpServletResponse httpResponse ) throws IOException {

        Rola rola = rolaService.getOneById(1); // pobranie roli (pod id 5 mam przodownik)
        Uzytkownik uzytkownik = new Uzytkownik(login, haslo, email, rola); // tworze użytkownika z referencją do pobranej roli
        rola.getUzytkownicy().add(uzytkownik); // dodaj użytkownika do roli (relacja jeden do wielu)
        Przodownik przodownik = new Przodownik(imie, nazwisko, telefon, uzytkownik); // stwórz przodownika z utworzonym użytkownikiem

        przodownikService.createPrzodownik(przodownik); // puść inserta do bazy
        // UWAGA! kolejność operacji jest ważna.


        //redirectAttributes.addFlashAttribute("WIADOMOSC", "wiadomosc");
        httpResponse.sendRedirect("/przodownicy");
    }

    @GetMapping("/przodownicy/usun/{id_przodownik}") // usuń przodownika wraz z jego kontem użytkownika
    public void removePrzodownik(@PathVariable Integer id_przodownik,
                                 HttpServletResponse httpResponse) throws IOException {

        Przodownik przodownik = przodownikService.getOneById(id_przodownik); // pobieram przodownika po odebranym id
        Uzytkownik uzytkownik = przodownik.getUzytkownik(); // pobieram uzytkownika przypisanego do przodownika
        przodownik.setUzytkownik(null); // usuwam referencje do rodzica

        uzytkownikService.removeUzytkownik(uzytkownik.getIdUzytkownik()); // usuwam użytkownika i od razu kaskadowo usuwa się przodownik.

        httpResponse.sendRedirect("/przodownicy");
    }

    @GetMapping({"/przodownicy/form", "/przodownicy/form/{id_przodownik}"})
    public ModelAndView formPrzodownik(@PathVariable(required = false) Integer id_przodownik) {

        modelAndView = new ModelAndView("przodownik/przodownicyForm");

        if(id_przodownik != null){
            Przodownik przodownik = przodownikService.getOneById(id_przodownik);
            modelAndView.addObject("przodownik", przodownik);
            modelAndView.addObject("update", "1");
        }

        return modelAndView;
    }

    @PostMapping("/przodownicy/update/{id_przodownik}")
    public void updatePrzodownik(@RequestParam(value="imie") String imie,
                                 @RequestParam(value="nazwisko") String nazwisko,
                                 @RequestParam(value="telefon") String telefon,
                                 @RequestParam(value="login") String login,
                                 @RequestParam(value="haslo", required = false) String haslo,
                                 @RequestParam(value="email") String email,
                                 @PathVariable Integer id_przodownik,
                                 HttpServletResponse httpResponse ) throws IOException {

        Przodownik przodownik = przodownikService.getOneById(id_przodownik);

        przodownik.setImie(imie);
        przodownik.setNazwisko(nazwisko);
        przodownik.setTelefon(telefon);
        przodownik.getUzytkownik().setLogin(login);
        przodownik.getUzytkownik().setEmail(email);

        przodownikService.createPrzodownik(przodownik);

        httpResponse.sendRedirect("/przodownicy");
    }
}
