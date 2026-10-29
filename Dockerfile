# Stage 1: build
FROM gradle:8.10-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# Stage 2: run
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
