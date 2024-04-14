package com.meriem.casavia.repositories;

import com.meriem.casavia.entities.Partenaire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartenaireRepository extends JpaRepository<Partenaire,Long> {
    Partenaire findPartenaireByEmail(String email);
    boolean existsByEmail(String email);
}
