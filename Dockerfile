FROM openjdk:8
EXPOSE 8085
ADD target/sector-details.jar sector-details.jar
ENTRYPOINT ["java","-jar","/sector-details.jar"]