FROM openjdk:8-jdk-alpine 
VOLUME /tmp 
COPY target/PersonalAppAccount-0.0.1-SNAPSHOT.jar personal-app-account.jar 
ENTRYPOINT ["java","-jar","personal-app-account.jar"]