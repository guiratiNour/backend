package com.meriem.casavia.services;

import com.meriem.casavia.entities.Categorie;
import com.meriem.casavia.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired// injecter une instance de CategorieRepository dans le service CategorieRepository
    CategorieRepository categorieRepository;
    @Override
    public Categorie ajouterCategorie(Categorie c) {
        return categorieRepository.save(c);// injecter une instance de CategorieRepository dans le service CategorieRepository
    }
}
