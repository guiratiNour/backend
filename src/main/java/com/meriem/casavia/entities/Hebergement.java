package com.meriem.casavia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Hebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hebergement_id; 
    private String nom;
    private String description;
    private String ville;
    private String pays;
    private double prix;
    private double distance;
    private String contact;
    private String adresse;
    private String politiqueAnnulation;
    private String nbEtoile;
    private double superficie;
    private int nb_Salles_De_Bains;
    private int nb_Chambres;
    private boolean dispo;

    @ManyToOne//  plusieurs instances de la classe Hebergement peuvent être associées à une seule instance de la classe Categorie
    private Categorie categorie;
    @OneToMany (mappedBy = "hebergement") //un hebergement peut avoir une ou plusieurs liste d'images
    private List<Image> images;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(// @JoinTable est utilisée pour mapper une relation many-to-many entre les classes Hebergement et Equipement
    		name = "hebergement_equipement",
            joinColumns = @JoinColumn(name = "hebergement_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    private List<Equipement> equipements;
    @OneToMany(mappedBy = "hebergement")
    @JsonIgnore
    private List<Avis> avisList;
	public Long getHebergement_id() {
		return hebergement_id;
	}
	public void setHebergement_id(Long hebergement_id) {
		this.hebergement_id = hebergement_id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPolitiqueAnnulation() {
		return politiqueAnnulation;
	}
	public void setPolitiqueAnnulation(String politiqueAnnulation) {
		this.politiqueAnnulation = politiqueAnnulation;
	}
	public String getNbEtoile() {
		return nbEtoile;
	}
	public void setNbEtoile(String nbEtoile) {
		this.nbEtoile = nbEtoile;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public int getNb_Salles_De_Bains() {
		return nb_Salles_De_Bains;
	}
	public void setNb_Salles_De_Bains(int nb_Salles_De_Bains) {
		this.nb_Salles_De_Bains = nb_Salles_De_Bains;
	}
	public int getNb_Chambres() {
		return nb_Chambres;
	}
	public void setNb_Chambres(int nb_Chambres) {
		this.nb_Chambres = nb_Chambres;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	public List<Avis> getAvisList() {
		return avisList;
	}
	public void setAvisList(List<Avis> avisList) {
		this.avisList = avisList;
	}
    
}
