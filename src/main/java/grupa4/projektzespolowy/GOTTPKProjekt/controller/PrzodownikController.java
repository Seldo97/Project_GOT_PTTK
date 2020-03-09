package grupa4.projektzespolowy.GOTTPKProjekt.controller;

import grupa4.projektzespolowy.GOTTPKProjekt.model.Przodownik;
import grupa4.projektzespolowy.GOTTPKProjekt.service.PrzodownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrzodownikController {
    @Autowired
    private PrzodownikService przodownikService;

    @GetMapping("/przodownicy")
    public ResponseEntity < List <Przodownik>> getAllProduct() {
        return ResponseEntity.ok().body(przodownikService.getAllProduct());
    }

    @PostMapping("/przodownicy")
    public ResponseEntity < Przodownik > createProduct(@RequestBody Przodownik przodownik) {
        return ResponseEntity.ok().body(this.przodownikService.createPrzodownik(przodownik));
    }
}
