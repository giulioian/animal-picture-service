package com.example.animalpics.controller;

import com.example.animalpics.service.AnimalPictureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnimalPictureController.class)
public class AnimalPictureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalPictureService service;

    @Test
    void fetchAndSavePictures_ValidRequest_Returns200() throws Exception {
        // Arrange
        doNothing().when(service).fetchAndSavePictures(anyString(), anyInt());

        // Act & Assert
        mockMvc.perform(post("/api/pictures/cat")
                        .param("count", "1"))
                .andExpect(status().isOk());

        verify(service).fetchAndSavePictures("cat", 1);
    }

    @Test
    void getLastPicture_ExistingPicture_ReturnsImage() throws Exception {
        // Arrange
        byte[] mockImage = "test image".getBytes();
        when(service.getLastPicture("cat")).thenReturn(mockImage);

        // Act & Assert
        mockMvc.perform(get("/api/pictures/cat/latest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_JPEG_VALUE))
                .andExpect(content().bytes(mockImage));
    }
}
