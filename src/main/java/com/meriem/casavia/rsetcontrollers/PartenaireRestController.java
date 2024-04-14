package com.meriem.casavia.rsetcontrollers;

import com.meriem.casavia.entities.Partenaire;

import com.meriem.casavia.repositories.PartenaireRepository;
import com.meriem.casavia.services.PartenaireService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/partenaire")
@CrossOrigin
public class PartenaireRestController {
    @Autowired
    PartenaireService partenaireserv;
    @Autowired
    PartenaireRepository partenaireRep;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/save")
    public Partenaire ajouterPartenaire(@RequestBody Partenaire p){
        p.setMot_de_passe(this.bCryptPasswordEncoder.encode(p.getMot_de_passe()));
        return partenaireserv.ajouterPartenaire(p);
    }
    @PutMapping("/update")
    public Partenaire modifierPartenaire(@RequestBody Partenaire p){
        p.setMot_de_passe(this.bCryptPasswordEncoder.encode(p.getMot_de_passe()));
        return partenaireserv.modifierPartenaire(p);
    }
    @DeleteMapping("/delete/{id}")
    public void supprimerPartenaire(@PathVariable("id") Long id){
        partenaireserv.supprimerPartenaiere(id);
    }
    @GetMapping("/all")
    public List<Partenaire> listPartenaire(){
        return partenaireserv.getAllPartenaire();
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginPartenaire(@RequestBody Partenaire p) {
        System.out.println("in login-partenaire" +p );
        HashMap<String, Object> response = new HashMap<>();

        Partenaire partFromDB = partenaireRep.findPartenaireByEmail(p.getEmail());
        System.out.println("partFromDB+p" + partFromDB);
        if (partFromDB == null) {
            response.put("message", "partenaire not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(p.getMot_de_passe(), partFromDB.getMot_de_passe());
            System.out.println("compare" + compare);
            if (!compare) {
                response.put("message", "partenaire not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                String token = Jwts.builder()
                        .claim("data", partFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }
}
