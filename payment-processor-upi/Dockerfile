FROM openjdk:8
WORKDIR /
COPY /out/artifacts/payment-processor/payment_processor_upi.jar ./kafka_consumer_upi.jar
EXPOSE 8081
CMD ["java","-jar","/kafka_consumer_upi.jar"]