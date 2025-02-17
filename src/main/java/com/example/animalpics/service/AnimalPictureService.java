package com.example.animalpics.service;

import com.example.animalpics.model.AnimalPicture;
import com.example.animalpics.repository.AnimalPictureRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AnimalPictureService {
    private static final Logger logger = LoggerFactory.getLogger(AnimalPictureService.class);	
    private final AnimalPictureRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final Random random = new Random();

    public AnimalPictureService(AnimalPictureRepository repository) {
        this.repository = repository;
    }

    public void fetchAndSavePictures(String animalType, int count) {
        for (int i = 0; i < count; i++) {
            try {
                int width = 300 + random.nextInt(200);
                int height = 300 + random.nextInt(200);
                
                String url = switch (animalType.toLowerCase()) {
                    case "cat" -> "https://loremflickr.com/300/300/cat";
                    case "dog" -> "https://place.dog/300/300";
                    case "bear" -> "https://placebear.com/300/300";
                    default -> throw new IllegalArgumentException("Invalid animal type");
                };
                logger.info("Fetching image from URL: {}", url);
                byte[] imageData = restTemplate.getForObject(url, byte[].class);

                if (imageData != null && imageData.length > 0) {
                    AnimalPicture picture = new AnimalPicture();
                    picture.setAnimalType(animalType);
                    picture.setImageData(imageData);
                    picture.setCreatedAt(LocalDateTime.now());
                    repository.save(picture);
                }
            } catch (Exception e) {
		logger.error("Error fetching image: ", e);
                throw new RuntimeException("Failed to fetch image: " + e.getMessage());
            }
        }
    }

    public byte[] getLastPicture(String animalType) {
        return repository.findTopByAnimalTypeOrderByCreatedAtDesc(animalType)
                .map(AnimalPicture::getImageData)
                .orElseThrow(() -> new RuntimeException("No picture found for: " + animalType));
    }
}
