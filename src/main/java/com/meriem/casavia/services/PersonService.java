package com.meriem.casavia.services;

import com.meriem.casavia.entities.Person;

import java.util.List;

public interface PersonService {
    Person ajouterPerson(Person p);
    Person modifierPerson(Person p);
    void supprimerPerson(Long id);
    List<Person> getAllPerson();


}
