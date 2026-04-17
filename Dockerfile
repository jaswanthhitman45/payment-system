# Replace openjdk with eclipse-temurin
FROM eclipse-temurin:17-jdk-focal

WORKDIR /app
COPY target/*.jar payment-app.jar
ENTRYPOINT ["java", "-jar", "payment-app.jar"]
