FROM openjdk:8
ADD target/CreditCard-0.0.1-SNAPSHOT.jar  CreditCard-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "CreditCard-0.0.1-SNAPSHOT.jar"]