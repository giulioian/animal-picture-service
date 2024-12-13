package com.example.animalpics.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnimalPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String animalType;
    
    @Lob
    private byte[] imageData;
    
    private LocalDateTime createdAt;

    // Default constructor
    public AnimalPicture() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
