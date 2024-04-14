package com.meriem.casavia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    private String type;
    @JsonIgnore

    @OneToMany(mappedBy = "categorie")//une catégorie peut avoir plusieurs hébergements

    private List<Hebergement> hebergements;
}
