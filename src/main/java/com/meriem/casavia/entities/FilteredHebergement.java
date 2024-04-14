package com.meriem.casavia.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class FilteredHebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Hebergement> filteredHebergements;

    // Getters and setters
}
