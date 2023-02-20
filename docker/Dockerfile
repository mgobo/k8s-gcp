FROM openjdk:17-alpine
RUN java -version

COPY ../target/hello-world.jar /

ENTRYPOINT "java" "-jar" "hello-world.jar"