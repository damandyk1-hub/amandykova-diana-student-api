# Student API - Amandykova Diana

Author: Amandykova Diana

Simple Spring Boot CRUD app for students. Uses PostgreSQL.

## Run

```
docker compose up -d --build
```

App: http://localhost:8080/students

## Endpoints

- GET /students - all students
- GET /students/{id} - one student
- POST /students - create
- PUT /students/{id} - update
- DELETE /students/{id} - delete
- GET /students/author - shows author name

Change by Amandykova Diana: DELETE now returns a message instead of empty body.
