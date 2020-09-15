FROM openjdk:8
ADD target/sector-details-microservice.jar sector-details-microservice.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","sector-details-microservice.jar"]