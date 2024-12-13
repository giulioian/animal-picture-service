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

	        private AnimalPictureService service;

		    @BeforeEach
		        void setUp() {
				        service = new AnimalPictureService(repository);
					    }

		        @Test
			    void fetchAndSavePictures_ValidAnimalType_SavesPicture() {
				            // Act & Assert
					    //         assertDoesNotThrow(() -> service.fetchAndSavePictures("cat", 1));
					    //
					    //                 // Verify that save was called at least once
					    //                         verify(repository, atLeastOnce()).save(any(AnimalPicture.class));
					    //                             }
					    //
					    //                                 @Test
					    //                                     void fetchAndSavePictures_InvalidAnimalType_ThrowsException() {
					    //                                             // Act & Assert
					    //                                                     Exception exception = assertThrows(RuntimeException.class,
					    //                                                                     () -> service.fetchAndSavePictures("invalid", 1));
					    //                                                                             assertTrue(exception.getMessage().contains("Invalid animal type"));
					    //                                                                                 }
					    //
					    //                                                                                     @Test
					    //                                                                                         void getLastPicture_ExistingPicture_ReturnsPicture() {
					    //                                                                                                 // Arrange
					    //                                                                                                         byte[] expectedData = "test image".getBytes();
					    //                                                                                                                 AnimalPicture mockPicture = new AnimalPicture();
					    //                                                                                                                         mockPicture.setImageData(expectedData);
					    //                                                                                                                                 when(repository.findTopByAnimalTypeOrderByCreatedAtDesc("cat"))
					    //                                                                                                                                                 .thenReturn(Optional.of(mockPicture));
					    //
					    //                                                                                                                                                         // Act
					    //                                                                                                                                                                 byte[] result = service.getLastPicture("cat");
					    //
					    //                                                                                                                                                                         // Assert
					    //                                                                                                                                                                                 assertArrayEquals(expectedData, result);
					    //                                                                                                                                                                                     }
					    //
					    //                                                                                                                                                                                         @Test
					    //                                                                                                                                                                                             void getLastPicture_NonExistingPicture_ThrowsException() {
					    //                                                                                                                                                                                                     // Arrange
					    //                                                                                                                                                                                                             when(repository.findTopByAnimalTypeOrderByCreatedAtDesc("cat"))
					    //                                                                                                                                                                                                                             .thenReturn(Optional.empty());
					    //
					    //                                                                                                                                                                                                                                     // Act & Assert
					    //                                                                                                                                                                                                                                             Exception exception = assertThrows(RuntimeException.class,
					    //                                                                                                                                                                                                                                                             () -> service.getLastPicture("cat"));
					    //                                                                                                                                                                                                                                                                     assertEquals("No picture found for: cat", exception.getMessage());
					    //                                                                                                                                                                                                                                                                         }
					    //                                                                                                                                                                                                                                                                         }
