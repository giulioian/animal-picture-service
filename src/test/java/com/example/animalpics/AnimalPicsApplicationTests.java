package com.example.animalpics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimalPicsApplicationTests {

	    @LocalServerPort
	        private int port;

	        private final TestRestTemplate restTemplate = new TestRestTemplate();

		    @Test
		        void contextLoads() {
				    }

		        @Test
			    void fetchPictures_EndToEnd_Success() {
				            // Arrange
					    //         String url = "http://localhost:" + port + "/api/pictures/cat?count=1";
					    //
					    //                 // Act
					    //                         ResponseEntity<Void> response = restTemplate.postForEntity(url, null, Void.class);
					    //
					    //                                 // Assert
					    //                                         assertEquals(HttpStatus.OK, response.getStatusCode());
					    //                                             }
					    //                                             }
