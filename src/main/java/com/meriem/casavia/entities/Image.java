package com.meriem.casavia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage ;
    private String name ;
    private String type ;
    @Column( name = "IMAGE" , length = 4048576 )
    @Lob
    private byte[] image;
    @ManyToOne()
    @JoinColumn(name="hebergement_id")
    @JsonIgnore
    private Hebergement hebergement;
	public Long getIdImage() {
		return idImage;
	}
	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Hebergement getHebergement() {
		return hebergement;
	}
	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}
	public static ImageBuilder builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
