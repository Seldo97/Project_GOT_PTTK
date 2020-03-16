package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Rola;
import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.RolaServiceImpl;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PrzodownikController {
    @Autowired // podłączamy Servicy z których bedzimy koszystać
    private PrzodownikServiceImpl przodownikServiceImpl;
    @Autowired
    private UzytkownikServiceImpl uzytkownikServiceImpl;
    @Autowired
    private RolaServiceImpl rolaServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/przodownicy") // ścieżka na której zostanie obsłużona metoda
    public String getAllPrzodownik(Model model, Authentication authentication) {

        model.addAttribute("przodownicy", przodownikServiceImpl.getAllPrzodownik());
        model.addAttribute("LoggedUser", authentication);

        return "przodownik/przodownicy";
    }

    @PostMapping("/przodownicy/dodaj")
    public String createPrzodownik(@RequestParam(value="imie") String imie,
                                  @RequestParam(value="nazwisko") String nazwisko,
                                  @RequestParam(value="telefon") String telefon,
                                  @RequestParam(value="login") String login,
                                  @RequestParam(value="haslo") String haslo,
                                  @RequestParam(value="email") String email,
                                   RedirectAttributes redirectAttributes) {

        Rola rola = rolaServiceImpl.getOneByName("ROLE_przodownik"); // pobranie roli (pod id 5 mam przodownik)3
        Uzytkownik uzytkownik = new Uzytkownik(login, passwordEncoder.encode(haslo), email, rola); // tworze użytkownika z referencją do pobranej roli
        rola.getUzytkownicy().add(uzytkownik); // dodaj użytkownika do roli (relacja jeden do wielu)
        Przodownik przodownik = new Przodownik(imie, nazwisko, telefon, uzytkownik); // stwórz przodownika z utworzonym użytkownikiem

        przodownikServiceImpl.createPrzodownik(przodownik); // puść inserta do bazy
        // UWAGA! kolejność operacji jest ważna.

        redirectAttributes.addFlashAttribute("wiadomosc", "Dodano Wiersz pomyślnie!"); // flash messages w przyszłości będzie rozbudowane

        return "redirect:/przodownicy";
    }

    //@PreAuthorize("administrator")
    @GetMapping("/przodownicy/usun/{id_przodownik}") // usuń przodownika wraz z jego kontem użytkownika
    public String removePrzodownik(@PathVariable Integer id_przodownik) {

        Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik); // pobieram przodownika po odebranym id
        Uzytkownik uzytkownik = przodownik.getUzytkownik(); // pobieram uzytkownika przypisanego do przodownika
        przodownik.setUzytkownik(null); // usuwam referencje do rodzica

        uzytkownikServiceImpl.removeUzytkownik(uzytkownik.getIdUzytkownik()); // usuwam użytkownika i od razu kaskadowo usuwa się przodownik.

        return "redirect:/przodownicy";
    }

    @GetMapping({"/przodownicy/form", "/przodownicy/form/{id_przodownik}"})
    public String formPrzodownik(Model model, @PathVariable(required = false) Integer id_przodownik) {


        if(id_przodownik != null){
            Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik);
            model.addAttribute("przodownik", przodownik);
            model.addAttribute("update", "1");
        }

        return "przodownik/przodownicyForm";
    }

    @PostMapping("/przodownicy/update/{id_przodownik}")
    public String updatePrzodownik(@RequestParam(value="imie") String imie,
                                 @RequestParam(value="nazwisko") String nazwisko,
                                 @RequestParam(value="telefon") String telefon,
                                 @RequestParam(value="login") String login,
                                 @RequestParam(value="haslo", required = false) String haslo,
                                 @RequestParam(value="email") String email,
                                 @PathVariable Integer id_przodownik) {

        Przodownik przodownik = przodownikServiceImpl.getOneById(id_przodownik);

        przodownik.setImie(imie);
        przodownik.setNazwisko(nazwisko);
        przodownik.setTelefon(telefon);
        przodownik.getUzytkownik().setLogin(login);
        if(haslo != "")
            przodownik.getUzytkownik().setHaslo(passwordEncoder.encode(haslo));
        przodownik.getUzytkownik().setEmail(email);

        przodownikServiceImpl.createPrzodownik(przodownik);

        return "redirect:/przodownicy";
    }
}
