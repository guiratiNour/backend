package com.meriem.casavia.services;

import com.meriem.casavia.entities.Partenaire;

import java.util.List;

public interface PartenaireService {
    Partenaire ajouterPartenaire(Partenaire p);
    Partenaire modifierPartenaire(Partenaire p);
    void supprimerPartenaiere(Long id);
    List<Partenaire> getAllPartenaire();


}
