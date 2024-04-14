package com.meriem.casavia.services;

import com.meriem.casavia.entities.Person;
import com.meriem.casavia.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository PartenaireRep;
    @Override
    public Person ajouterPerson(Person p) {
        return PartenaireRep.save(p);
    }

    @Override
    public Person modifierPerson(Person p) {
        return PartenaireRep.save(p);
    }

    @Override
    public void supprimerPerson(Long id) {
        PartenaireRep.deleteById(id);

    }

    @Override
    public List<Person> getAllPerson() {
        return PartenaireRep.findAll();
    }
}
