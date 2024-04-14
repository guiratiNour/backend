package com.meriem.casavia.services;

import com.meriem.casavia.entities.Partenaire;
import com.meriem.casavia.repositories.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartenaireServiceImpl implements PartenaireService{
    @Autowired
    PartenaireRepository PartenaireRep;
    @Override
    public Partenaire ajouterPartenaire(Partenaire p) {
        return PartenaireRep.save(p);
    }

    @Override
    public Partenaire modifierPartenaire(Partenaire p) {
        return PartenaireRep.save(p);
    }

    @Override
    public void supprimerPartenaiere(Long id) {
        PartenaireRep.deleteById(id);

    }

    @Override
    public List<Partenaire> getAllPartenaire() {
        return PartenaireRep.findAll();
    }
}
