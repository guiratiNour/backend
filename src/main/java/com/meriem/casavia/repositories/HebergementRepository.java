package com.meriem.casavia.repositories;

import com.meriem.casavia.entities.Categorie;
import com.meriem.casavia.entities.Hebergement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HebergementRepository extends JpaRepository<Hebergement,Long> {
    List<Hebergement> findByCategorie (Categorie categorie);
    List<Hebergement> findByCategorieIdCat(Long id);

}
