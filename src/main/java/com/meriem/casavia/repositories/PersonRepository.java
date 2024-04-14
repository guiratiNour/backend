package com.meriem.casavia.repositories;

import com.meriem.casavia.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findPersonByEmail(String email);
    boolean existsByEmail(String email);
}
