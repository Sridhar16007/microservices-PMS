# ----------------------------
# Stage 1: Build with Maven
# ----------------------------
FROM --platform=$BUILDPLATFORM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy POM and download dependencies (cache-friendly)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Verify that the JAR is built
RUN ls -l /app/target
RUN find /app/target -name "*.jar"

# ----------------------------
# Stage 2: Runner
# ----------------------------
FROM eclipse-temurin:21-jdk-jammy AS runner
WORKDIR /app

# Copy the built JAR dynamically (avoid hardcoding version)
COPY --from=builder /app/target/*.jar ./app.jar

# Verify the JAR exists
RUN ls -l /app/app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]
