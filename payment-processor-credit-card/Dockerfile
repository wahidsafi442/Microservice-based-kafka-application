FROM openjdk:8
WORKDIR /
COPY /out/artifacts/payment-processor/payment_processor_credit_card.jar ./kafka_consumer_credit_card.jar
EXPOSE 8081
CMD ["java","-jar","/kafka_consumer_credit_card.jar"]