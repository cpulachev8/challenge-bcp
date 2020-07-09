FROM adoptopenjdk/openjdk11
WORKDIR /
ADD /target/challenge-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
ENTRYPOINT [ "java","-jar","challenge-0.0.1-SNAPSHOT.jar" ]