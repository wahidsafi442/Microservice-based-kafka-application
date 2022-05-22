FROM openjdk:8
WORKDIR /
COPY /out/artifacts/payment-processor/payment_processor_pay_on_delivery.jar ./kafka_consumer_pay_on_delivery.jar
EXPOSE 8081
CMD ["java","-jar","/kafka_consumer_pay_on_delivery.jar"]