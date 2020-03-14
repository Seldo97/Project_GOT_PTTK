package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PrzodownikController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private PrzodownikServiceImpl przodownikServiceImpl;
    @Autowired
    private UzytkownikServiceImpl uzytkownikServiceImpl;
    @Autowired
    private RolaServiceImpl rolaServiceImpl;

    private ModelAndView modelAndView;

    @GetMapping("/przodownicy") // ścieżka na której zostanie obsłużona metoda
    public ModelAndView getAllPrzodownik() {

        modelAndView = new ModelAndView("przodownik/przodownicy"); // ścieżka do pliku twig który ma zostać wyrenderowany
        modelAndView.addObject("przodownicy", przodownikServiceImpl.getAllPrzodownik()); // dodanie zmiennych do twiga

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

        Rola rola = rolaServiceImpl.getOneByName("przodownik"); // pobranie roli (pod id 5 mam przodownik)3
        Uzytkownik uzytkownik = new Uzytkownik(login, haslo, email, rola); // tworze użytkownika z referencją do pobranej roli
        rola.getUzytkownicy().add(uzytkownik); // dodaj użytkownika do roli (relacja jeden do wielu)
        Przodownik przodownik = new Przodownik(imie, nazwisko, telefon, uzytkownik); // stwórz przodownika z utworzonym użytkownikiem

        przodownikServiceImpl.createPrzodownik(przodownik); // puść inserta do bazy
        // UWAGA! kolejność operacji jest ważna.


        //redirectAttributes.addFlashAttribute("WIADOMOSC", "wiadomosc");
        httpResponse.sendRedirect("/przodownicy");
    }

    @GetMapping("/przodownicy/usun/{id_przodownik}") // usuń przodownika wraz z jego kontem użytkownika
    public void removePrzodownik(@PathVariable Integer id_przodownik,
                                 HttpServletResponse httpResponse) throws IOException {

        Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik); // pobieram przodownika po odebranym id
        Uzytkownik uzytkownik = przodownik.getUzytkownik(); // pobieram uzytkownika przypisanego do przodownika
        przodownik.setUzytkownik(null); // usuwam referencje do rodzica

        uzytkownikServiceImpl.removeUzytkownik(uzytkownik.getIdUzytkownik()); // usuwam użytkownika i od razu kaskadowo usuwa się przodownik.

        httpResponse.sendRedirect("/przodownicy");
    }

    @GetMapping({"/przodownicy/form", "/przodownicy/form/{id_przodownik}"})
    public ModelAndView formPrzodownik(@PathVariable(required = false) Integer id_przodownik) {

        modelAndView = new ModelAndView("przodownik/przodownicyForm");

        if(id_przodownik != null){
            Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik);
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

        Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik);

        przodownik.setImie(imie);
        przodownik.setNazwisko(nazwisko);
        przodownik.setTelefon(telefon);
        przodownik.getUzytkownik().setLogin(login);
        przodownik.getUzytkownik().setEmail(email);

        przodownikServiceImpl.createPrzodownik(przodownik);

        httpResponse.sendRedirect("/przodownicy");
    }
}
