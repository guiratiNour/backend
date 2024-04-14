package com.meriem.casavia.services;

import java.util.List;
import com.meriem.casavia.entities.FilteredHebergement;

public interface FilteredHebergementService {
    List<FilteredHebergement> getAllFilteredHebergements();
    FilteredHebergement getFilteredHebergementById(Long id);
    FilteredHebergement saveFilteredHebergement(FilteredHebergement filteredHebergement);
    void deleteFilteredHebergement(Long id);
}

