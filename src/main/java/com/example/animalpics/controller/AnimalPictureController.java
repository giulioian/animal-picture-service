package com.example.animalpics.controller;

import com.example.animalpics.service.AnimalPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pictures")
public class AnimalPictureController {
    
    private final AnimalPictureService service;

    @Autowired
    public AnimalPictureController(AnimalPictureService service) {
        this.service = service;
    }

    @PostMapping("/{animalType}")
    public void fetchAndSavePictures(@PathVariable String animalType, @RequestParam int count) {
        service.fetchAndSavePictures(animalType, count);
    }

    @GetMapping(value = "/{animalType}/latest", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getLastPicture(@PathVariable String animalType) {
        return service.getLastPicture(animalType);
    }
}
