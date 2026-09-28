FROM maven:3.9.4-eclipse-temurin-21-alpine AS stage-1
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=stage-1 /app/target/url-shortener-0.0.1-SNAPSHOT.jar /app/urlshortener.jar
CMD ["java", "-jar", "urlshortener.jar"]