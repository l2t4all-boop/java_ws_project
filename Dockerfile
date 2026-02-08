FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY invoice-gen-app/pom.xml invoice-gen-app/mvnw ./
COPY invoice-gen-app/.mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B
COPY invoice-gen-app/src src
RUN ./mvnw package -DskipTests -B

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8081}"]