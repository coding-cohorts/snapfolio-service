# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-alpine as build

# Set the working directory in the container
WORKDIR /app

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle /app/

# Copy the gradle wrapper files
COPY gradlew /app/
COPY gradle /app/gradle

# Download the dependencies
RUN ./gradlew dependencies --no-daemon

# Copy the project source
COPY src /app/src

# Build the application
RUN ./gradlew bootJar --no-daemon

# Use a smaller base image for the final image
FROM openjdk:23-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/snapfolio-service-0.0.1-SNAPSHOT.jar /app/snapfolio-service-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "snapfolio-service-0.0.1-SNAPSHOT.jar"]