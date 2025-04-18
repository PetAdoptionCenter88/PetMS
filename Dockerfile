# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the local machine (replace with your actual path)
COPY target/PetMS-0.0.1-SNAPSHOT.jar /app/petms.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/petms.jar"]
