FROM openjdk:11
EXPOSE 8080/tcp
COPY . /usr/src/statuspage2
WORKDIR /usr/src/statuspage2
CMD ["./mvnw", "clean", "install"]
CMD ["java", "-jar", "./target/statuspage-0.0.1-SNAPSHOT.jar"]