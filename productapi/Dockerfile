
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app


COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN mvn -q dependency:go-offline

COPY src src

RUN mvn -q clean package -DskipTests


FROM eclipse-temurin:21-jre

ENV JAVA_OPTS="-XX:MaxRAMPercentage=75 -XX:+UseG1GC -Dfile.encoding=UTF-8"

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar


EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
