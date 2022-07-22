## Intro
API to count how many times the word expected repeat in the files and testing how to read the files in parallel
```
localhost:8080/word/{word}
```


Project dependencies :
- Java 8
- Docker 
- Git CI

# Run
How to run
```
mvn package

java -jar target/*.jar
```


# Run from Docker
```
docker build -f Dockerfile -t words-api .

docker run -p 8080:8080 words-api
```
