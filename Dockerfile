# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the generated JAR (fixes path mismatch issues)
COPY target/*.jar payment-app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "payment-app.jar"]
