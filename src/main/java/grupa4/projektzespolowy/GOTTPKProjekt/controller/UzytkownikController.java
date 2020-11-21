package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.exception.UserDoesNotExistException;
import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Uzytkownik;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UzytkownikController {
    @Autowired
    private UzytkownikService uzytkownikService;

    private ModelAndView modelAndView;

    @GetMapping("/uzytkownicy")
    public ModelAndView getAllProduct() {

        modelAndView = new ModelAndView("uzytkownik/uzytkownik");
        modelAndView.addObject("uzytkownicy", uzytkownikService.getAllUzytkownik());
        return modelAndView;
    }

    @PostMapping("/uzytkownik")
    public ResponseEntity<Uzytkownik> createProduct(@RequestBody Uzytkownik uzytkownik) {
        return ResponseEntity.ok().body(this.uzytkownikService.createUzytkownik(uzytkownik));
    }

    @GetMapping("/uzytkownik/addForm")
    public ModelAndView addformUzytkownik() {

        modelAndView = new ModelAndView("turysta/addForm");
        return modelAndView;
    }

    @GetMapping("/aktywacja/{uuid}")
    public String enableUserByLink(@PathVariable String uuid, RedirectAttributes redirectAttributes) throws UserDoesNotExistException {
        uzytkownikService.enableUser(uuid);
        redirectAttributes.addFlashAttribute("success_msg", "Konto zostało aktywowane, możesz się zalogować na swoje konto.");
        return "redirect:/";
    }

    @GetMapping("/aktywacja/zmien-status/{id}")
    public String enableUserByClick(@PathVariable Long id, RedirectAttributes redirectAttributes,
                                    HttpServletRequest request) throws UserDoesNotExistException {
        String referer = request.getHeader("Referer");
        uzytkownikService.enableUser(id);
        redirectAttributes.addFlashAttribute("success_msg", "Zmieniono status konta użytkownika pomyślnie");
        return "redirect:" + referer;
    }

    @ExceptionHandler(UserDoesNotExistException.class)
    public String UserDoesNotExistExceptionHandler(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error_msg", "Użytkownik nie istnieje");
        return "redirect:/";
    }

}
