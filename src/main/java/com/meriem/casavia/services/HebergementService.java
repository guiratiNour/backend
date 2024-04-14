package com.meriem.casavia.services;

import com.meriem.casavia.entities.Categorie;
import com.meriem.casavia.entities.Hebergement;

import java.util.List;

public interface HebergementService {
    Hebergement createHebergement(Hebergement hebergement);
    Hebergement updateHebergement( Hebergement Hebergement);
    void deleteHebergement(Long id);

    List<Hebergement> getAllHebergements();
    List<Hebergement> findByCategorie (Categorie categorie);
    List<Hebergement> findByCategorieIdCat(Long id);
    Hebergement getHebergementById(Long id);
  
}
