package com.meriem.casavia.services;

import com.meriem.casavia.entities.Categorie;
import com.meriem.casavia.entities.Hebergement;
import com.meriem.casavia.repositories.HebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class HebergementServiceImpl implements HebergementService{

    @Autowired
    private HebergementRepository hebergementRepository;

    @Override
    public Hebergement createHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    @Override
    public Hebergement updateHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }


    @Override
    public void deleteHebergement(Long id) {
        hebergementRepository.deleteById(id);
    }



    @Override
    public List<Hebergement> getAllHebergements() {
        return hebergementRepository.findAll();
    }
    @Override
    public List<Hebergement> findByCategorie(Categorie categorie) {
        return hebergementRepository.findByCategorie(categorie);
    }
    @Override
    public List<Hebergement> findByCategorieIdCat(Long id) {
        return hebergementRepository.findByCategorieIdCat(id);
    }
    @Override
    public Hebergement getHebergementById(Long id) {
        return hebergementRepository.findById(id)
                .orElse(null);
    }
   
}
