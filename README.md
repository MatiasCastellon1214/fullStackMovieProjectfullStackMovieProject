# MovieAPI 🎬

Web application to browse movies, watch movie trailers and submit reviews, built with React, Spring Boot and MongoDB.

![Demo](front/MovieClient/movie-gold-v1/public/fullstackMovieProject.gif) <!-- Reemplaza con una imagen real de tu app -->

## Features ✨

- View 10 movies with their details
- Plays embedded YouTube trailers
- Review system with interactive form
- Persistent storage of reviews in MongoDB Atlas
- Responsive design with Bootstrap
- RESTful API architecture

## Technologies 🛠️

### Frontend
![React](https://img.shields.io/badge/-React-61DAFB?logo=react&logoColor=white&style=flat)
![JavaScript](https://img.shields.io/badge/-JavaScript-F7DF1E?logo=javascript&logoColor=black&style=flat)
![HTML5](https://img.shields.io/badge/-HTML5-E34F26?logo=html5&logoColor=white&style=flat)
![CSS3](https://img.shields.io/badge/-CSS3-1572B6?logo=css3&logoColor=white&style=flat)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-7952B3?logo=bootstrap&logoColor=white&style=flat)
![Axios](https://img.shields.io/badge/-Axios-5A29E4?logo=axios&logoColor=white&style=flat)

### Backend
![Spring Boot](https://img.shields.io/badge/-Spring_Boot-6DB33F?logo=spring-boot&logoColor=white&style=flat)
![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white&style=flat)
![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apache-maven&logoColor=white&style=flat)

### Database
![MongoDB](https://img.shields.io/badge/-MongoDB-47A248?logo=mongodb&logoColor=white&style=flat)
![MongoDB Atlas](https://img.shields.io/badge/-MongoDB_Atlas-47A248?logo=mongodb&logoColor=white&style=flat)

## Project Roadmap 🗺️

### Completed Tasks ✅
- Basic movie listing from JSON file
- Movie detail view with trailer
- Review submission form
- MongoDB integration for reviews
- Basic API endpoints

### Pending Tasks ⏳
| Task | Status | Priority |
|------|--------|----------|
| Complete all API endpoints | In progress | High |
| Implement unit tests (JUnit, Jest) | Not started | High |
| Dockerize application | Not started | Medium |
| Add authentication for reviews | Not started | Medium |
| Implement pagination for movies | Not started | Low |
| Add search functionality | Not started | Low |
| Improve error handling | Not started | Medium |

## Configuration ⚙️

### Prerequisites
- Node.js (v14+)
- Java JDK (11+)
- Maven (3.6+)
- MongoDB Atlas (or local)

### Installation

1. **Backend (Spring Boot)
   ````bash
   cd backend
   mvn clean install
   mvn spring-boot:run

2. **Frontend (React)
   ````bash
   cd frontend
   npm install
   npm start

3. **MongoDB Configuration

- Create a cluster in MongoDB Atlas
- Get the connection string
- Configure in backend/src/main/resources/application.properties:
```bash
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@clusterX.mongodb.net/<dbname>?retryWrites=true&w=majority
```

## Endpoints API 🌐

### Movies

GET /api/v1/movies - Get all movies

GET /api/v1/movies/{imdbId} - Gets a movie for its ID

#### Example Data 🎥
Movies are loaded from movies.json which contains:

```json
{
  "imdbId": "tt3915174",
  "title": "Puss in Boots: The Last Wish",
  "releaseDate": "2022-12-21",
  "trailerLink": "https://www.youtube.com/watch?v=tHb7WlgyaUc",
  "genres": ["Animation", "Action", "Adventure", "Comedy", "Family"],
  "poster": "https://image.tmdb.org/t/p/w500/1NqwE6LP9IEdOZ57NCT51ftHtWT.jpg",
  "backdrops": [...],
  "reviewIds": []
}
```

### Reviews

GET /api/v1/reviews - Get all reviews

```json
[
    {
        "id": "67e9a9f97fb0d54f3adeb57d",
        "body": "Cool animations"
    },
    {
        "id": "67e9deeef3905717a52c41c7",
        "body": "Excelente animación y narrativa. Antonio Banderas está brillante como siempre en su papel de Puss in Boots."
    },
    {
        "id": "67e9ec0e0b9e98388b622d8f",
        "body": "No idea"
    }
]
```

POST /api/v1/reviews/ - Submit a new review

```json
{
    "id": "67eb34721641970b0a6fa889",
    "body": "the film surprised me, very good."
}
```

DELETE /api/v1/reviews/{imdbId} - Remove a review by its ID

```raw
Review successfully removed
```

## Contribution 🤝

1. Fork the project
2. Create your feature branch (git checkout -b feature/AmazingFeature)
3. Commit your changes (git commit -m 'Add some AmazingFeature')
4. Push to the branch (git push origin feature/AmazingFeature)
5. Open a Pull Request
