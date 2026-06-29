FROM eclipse-temurin:25.0.3_9-jre-noble AS builder
WORKDIR /extracted
ADD ./build/libs/*.jar app.jar
RUN java -Djarmode=tools -jar app.jar extract --layers --destination extracted_layers

FROM eclipse-temurin:25.0.3_9-jre-noble
WORKDIR /application
COPY --from=builder /extracted/extracted_layers/dependencies/ ./
COPY --from=builder /extracted/extracted_layers/spring-boot-loader/ ./
COPY --from=builder /extracted/extracted_layers/snapshot-dependencies/ ./
COPY --from=builder /extracted/extracted_layers/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]