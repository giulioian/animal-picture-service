# Animal Picture Service

A Spring Boot application that fetches and stores animal pictures from various online sources. The service supports cats, dogs, and bears, providing an easy-to-use web interface for managing animal pictures.

## Features

- Fetch and store animal pictures from different sources
- View the latest picture for each animal type
- Simple web interface
- H2 in-memory database for storage
- RESTful API endpoints

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git (optional)

## Technology Stack

- Spring Boot 3.2.1
- Spring Data JPA
- H2 Database
- Spring Web
- Maven

## Quick Start

1. Clone the repository:
git clone https://github.com/yourusername/animal-picture-service.git
cd animal-picture-service


2. Build the project:
./mvnw clean package


3. Run the application:
java -jar target/animal-pics-1.0.0.jar


4. Access the web interface:
http://localhost:8080


## API Endpoints

### Fetch Pictures

POST /api/pictures/{animalType}?count={count}
- `animalType`: cat, dog, or bear
- `count`: number of pictures to fetch

### Get Latest Picture

GET /api/pictures/{animalType}/latest
- Returns the most recently stored picture for the specified animal type
- Returns image in JPEG format

## Database Access

The H2 console is available at:

http://localhost:8080/h2-console

Connection details:
- JDBC URL: `jdbc:h2:mem:animalsdb`
- Username: `sa`
- Password: `password`

## Project Structure

animal-picture-service/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/animalpics/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── AnimalPicsApplication.java
│ │ └── resources/
│ │ ├── static/
│ │ │ └── index.html
│ │ └── application.yml
│ └── test/
├── pom.xml
├── Dockerfile
├── docker-compose.yml
└── README.md


## Docker Support

Build the Docker image:
docker build -t animal-picture-service .

Run with Docker Compose:
docker-compose up

## Usage Examples

### Using the Web Interface

1. Open `http://localhost:8080`
2. To fetch new pictures:
   - Select an animal type from the dropdown
   - Enter the number of pictures to fetch
   - Click "Fetch"
3. To view the latest picture:
   - Select an animal type
   - Click "View"

### Using cURL

Fetch 3 cat pictures:
curl -X POST "http://localhost:8080/api/pictures/cat?count=3"

Get the latest dog picture:
curl -X GET "http://localhost:8080/api/pictures/dog/latest" --output dog.jpg

## Image Sources

The service uses the following APIs to fetch images:
- Cats: https://cataas.com
- Dogs: https://place.dog
- Bears: https://placebear.com

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Troubleshooting

### Common Issues

1. Application won't start
   - Verify Java 17 is installed: `java -version`
   - Check if port 8080 is available

2. Cannot fetch images
   - Verify internet connection
   - Check if image APIs are accessible

3. H2 Console access issues
   - Verify correct connection details
   - Ensure console is enabled in `application.yml`

For more issues, please check the application logs or open an issue on GitHub.

## Contact

Your Name - giulioian@gmail.com

Project Link: https://github.com/giulioian/animal-picture-service



