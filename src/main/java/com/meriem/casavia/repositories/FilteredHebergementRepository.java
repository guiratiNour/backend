package com.meriem.casavia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meriem.casavia.entities.FilteredHebergement;

@Repository
public interface FilteredHebergementRepository extends JpaRepository<FilteredHebergement, Long> {
    
}

