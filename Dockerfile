FROM frolvlad/alpine-oraclejdk8:slim
ADD build/libs/calculator-0.0.1-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]