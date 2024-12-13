package com.example.animalpics.controller;

import com.example.animalpics.service.AnimalPictureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AnimalPictureControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AnimalPictureService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        AnimalPictureController controller = new AnimalPictureController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testFetchAndSavePictures() throws Exception {
        mockMvc.perform(post("/api/pictures/cat")
                .param("count", "1"))
                .andExpect(status().isOk());

        verify(service).fetchAndSavePictures("cat", 1);
    }

    @Test
    void testGetLastPicture() throws Exception {
        byte[] dummyImage = "test image".getBytes();
        when(service.getLastPicture("cat")).thenReturn(dummyImage);

        mockMvc.perform(get("/api/pictures/cat/latest")
                .accept(MediaType.IMAGE_JPEG))
                .andExpect(status().isOk());
    }
}
