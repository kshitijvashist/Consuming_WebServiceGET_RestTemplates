FROM java:8
EXPOSE 8080
ADD /target/Consuming_WebServiceGET_RestTemplates.jar Consuming_WebServiceGET_RestTemplates.jar
ENTRYPOINT ["java","-jar","Consuming_WebServiceGET_RestTemplates.jar"]