FROM openjdk:8
ADD target/*.jar app.jar
ADD words-amostra/ words-amostra
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]