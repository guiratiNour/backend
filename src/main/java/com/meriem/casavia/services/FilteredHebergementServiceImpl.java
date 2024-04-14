package com.meriem.casavia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.meriem.casavia.entities.FilteredHebergement;
import com.meriem.casavia.repositories.FilteredHebergementRepository;

@Service
public class FilteredHebergementServiceImpl implements FilteredHebergementService {
    
    @Autowired
    private FilteredHebergementRepository filteredHebergementRepository;

    @Override
    public List<FilteredHebergement> getAllFilteredHebergements() {
        return filteredHebergementRepository.findAll();
    }

    @Override
    public FilteredHebergement getFilteredHebergementById(Long id) {
        Optional<FilteredHebergement> optionalFilteredHebergement = filteredHebergementRepository.findById(id);
        return optionalFilteredHebergement.orElse(null);
    }

    @Override
    public FilteredHebergement saveFilteredHebergement(FilteredHebergement filteredHebergement) {
        return filteredHebergementRepository.save(filteredHebergement);
    }

    @Override
    public void deleteFilteredHebergement(Long id) {
        filteredHebergementRepository.deleteById(id);
    }
}

