FROM openjdk:8
EXPOSE 8085
ADD target/sector-detail.jar sector-detail.jar
ENTRYPOINT ["java","-jar","/sector-detail.jar"]