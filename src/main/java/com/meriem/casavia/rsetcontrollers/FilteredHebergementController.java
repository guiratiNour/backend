package com.meriem.casavia.rsetcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.meriem.casavia.entities.FilteredHebergement;
import com.meriem.casavia.services.FilteredHebergementService;

@RestController
@RequestMapping("/api/filtered-hebergements")
public class FilteredHebergementController {

    @Autowired
    private FilteredHebergementService filteredHebergementService;

    @GetMapping
    public ResponseEntity<List<FilteredHebergement>> getAllFilteredHebergements() {
        List<FilteredHebergement> filteredHebergements = filteredHebergementService.getAllFilteredHebergements();
        return new ResponseEntity<>(filteredHebergements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilteredHebergement> getFilteredHebergementById(@PathVariable("id") Long id) {
        FilteredHebergement filteredHebergement = filteredHebergementService.getFilteredHebergementById(id);
        if (filteredHebergement != null) {
            return new ResponseEntity<>(filteredHebergement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<FilteredHebergement> createFilteredHebergement(@RequestBody FilteredHebergement filteredHebergement) {
        FilteredHebergement createdFilteredHebergement = filteredHebergementService.saveFilteredHebergement(filteredHebergement);
        return new ResponseEntity<>(createdFilteredHebergement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilteredHebergement> updateFilteredHebergement(@PathVariable("id") Long id, @RequestBody FilteredHebergement filteredHebergement) {
        FilteredHebergement existingFilteredHebergement = filteredHebergementService.getFilteredHebergementById(id);
        if (existingFilteredHebergement != null) {
            filteredHebergement.setId(id);
            FilteredHebergement updatedFilteredHebergement = filteredHebergementService.saveFilteredHebergement(filteredHebergement);
            return new ResponseEntity<>(updatedFilteredHebergement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilteredHebergement(@PathVariable("id") Long id) {
        FilteredHebergement existingFilteredHebergement = filteredHebergementService.getFilteredHebergementById(id);
        if (existingFilteredHebergement != null) {
            filteredHebergementService.deleteFilteredHebergement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

