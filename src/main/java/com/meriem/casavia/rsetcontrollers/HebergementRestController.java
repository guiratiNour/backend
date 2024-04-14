package com.meriem.casavia.rsetcontrollers;
import org.springframework.http.ResponseEntity;
import com.meriem.casavia.entities.Hebergement;

import com.meriem.casavia.repositories.CategorieRepository;

import com.meriem.casavia.services.HebergementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hebergement")
@RestController
@CrossOrigin
public class HebergementRestController {
    @Autowired
    private HebergementService hebergementService;
    @Autowired
    CategorieRepository categorieRep;
    @GetMapping("/all")
    public List<Hebergement> getAllHebergements() {
        return hebergementService.getAllHebergements();
    }

    @PostMapping("/save")
    public Hebergement createHebergement(@RequestParam Long categorie,@RequestBody Hebergement hebergement) {
        System.out.println(categorie);

        hebergement.setCategorie(categorieRep.findById(categorie).get());

        return hebergementService.createHebergement(hebergement);

    }

    @PutMapping("/update")
    public Hebergement updateHebergement( @RequestBody Hebergement updatedHebergement) {
        return hebergementService.updateHebergement(updatedHebergement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHebergement(@PathVariable("id") Long id) {
        hebergementService.deleteHebergement(id);
    }
    @GetMapping ("/hebergements/{idCat}")
    public List<Hebergement> getHebergementsByCatId(@PathVariable("idCat") Long idCat) {
        return hebergementService.findByCategorieIdCat(idCat);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hebergement> getHebergementById(@PathVariable("id") Long id) {
        Hebergement hebergement = hebergementService.getHebergementById(id);
        if (hebergement != null) {
            return new ResponseEntity<>(hebergement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
