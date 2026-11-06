
# Stage 1: Build the Spring Boot application
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copy Maven wrapper and configuration
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

# Copy application source code
COPY src/ src/

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw -B clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy generated JAR file
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8001

# Start application
ENTRYPOINT ["java", "-jar", "app.jar"]