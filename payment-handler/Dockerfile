FROM openjdk:8
WORKDIR /
COPY /out/artifacts/payment-handler/payment-handler.jar ./kafka-producer.jar
EXPOSE 8080
CMD ["java","-jar","/kafka-producer.jar"]