package com.example.animalpics.repository;

import com.example.animalpics.model.AnimalPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AnimalPictureRepository extends JpaRepository<AnimalPicture, Long> {
    Optional<AnimalPicture> findTopByAnimalTypeOrderByCreatedAtDesc(String animalType);
}
