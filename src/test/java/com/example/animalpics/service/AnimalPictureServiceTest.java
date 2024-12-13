package com.example.animalpics.service;

import com.example.animalpics.model.AnimalPicture;
import com.example.animalpics.repository.AnimalPictureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimalPictureServiceTest {

    @Mock
    private AnimalPictureRepository repository;

    @Mock
    private RestTemplate restTemplate;

    private AnimalPictureService service;

    @BeforeEach
    void setUp() {
        service = new AnimalPictureService(repository);
    }

    @Test
    void fetchAndSavePictures_ValidAnimalType_SavesPicture() {
        // Arrange
        byte[] mockImageData = "mock image data".getBytes();
        when(restTemplate.getForObject(anyString(), eq(byte[].class)))
                .thenReturn(mockImageData);

        // Act
        assertDoesNotThrow(() -> service.fetchAndSavePictures("cat", 1));

        // Assert
        verify(repository, times(1)).save(any(AnimalPicture.class));
    }

    @Test
    void fetchAndSavePictures_InvalidAnimalType_ThrowsException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> service.fetchAndSavePictures("invalid", 1));
    }

    @Test
    void getLastPicture_ExistingPicture_ReturnsPicture() {
        // Arrange
        byte[] expectedData = "test image".getBytes();
        AnimalPicture mockPicture = new AnimalPicture();
        mockPicture.setImageData(expectedData);
        when(repository.findTopByAnimalTypeOrderByCreatedAtDesc("cat"))
                .thenReturn(Optional.of(mockPicture));

        // Act
        byte[] result = service.getLastPicture("cat");

        // Assert
        assertArrayEquals(expectedData, result);
    }

    @Test
    void getLastPicture_NonExistingPicture_ThrowsException() {
        // Arrange
        when(repository.findTopByAnimalTypeOrderByCreatedAtDesc("cat"))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class,
                () -> service.getLastPicture("cat"));
    }
}
