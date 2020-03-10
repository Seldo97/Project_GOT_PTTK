package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PrzodownikController {
    @Autowired
    private PrzodownikService przodownikService;

    @GetMapping("/przodownicy")
    public ModelAndView getAllProduct() {

        ModelAndView modelAndView = new ModelAndView("przodownicy");
        modelAndView.addObject("przodownicy", przodownikService.getAllPrzodownik());
        return modelAndView;
    }

    @PostMapping("/przodownicy/dodaj")
    public void createProduct(@RequestParam(value="imie", required=false) String imie,
                                @RequestParam(value="nazwisko", required=false) String nazwisko,
                                @RequestParam(value="telefon", required=false) String telefon,
                                HttpServletResponse httpResponse) throws IOException {

        var przodownik = new Przodownik(imie, nazwisko, telefon);
        przodownikService.createPrzodownik(przodownik);

        httpResponse.sendRedirect("/przodownicy");
    }
}
