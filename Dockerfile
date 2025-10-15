FROM eclipse-temurin:17-jre-jammy
LABEL authors="starry"

COPY ./target/big_event-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]