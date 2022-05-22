package com.payment;
import com.payment.kafka.PaymentTypes;
import com.payment.kafka.producer.PaymentFactory;
import com.payment.kafka.producer.PaymentProducer;
import com.payment.kafka.producer.RequestParser;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

@SpringBootApplication
public class PaymentHandler {

    public static final Logger LOG = LoggerFactory.getLogger(PaymentHandler.class);

    public static void main(String[] args) { runProducer();}

    public static void runProducer() {

        LOG.info("Kafka producer is running");

        Producer<String, PaymentFactory> producer = PaymentProducer.createProducer();
        RequestParser r = new RequestParser();

        // Creating Kafka-producer for each payment type which is map to each topic.
        EnumSet.allOf(PaymentTypes.class)
                .forEach(paymentType -> {

                PaymentFactory paymentObj = r.parseRequest("C:/project/payment-handler/inputs/"+paymentType+".json");
                producer.send(new ProducerRecord<>(paymentType.toString(), paymentObj.paymentType, paymentObj), new Callback() {
                @Override

                public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                if (exception == null) {
                         LOG.info("topic : " + recordMetadata.topic() + "\n" +
                                        "partition : " + recordMetadata.partition() + "\n" +
                                        "timestamp :" + recordMetadata.timestamp() + "\n" +
                                        "offset :" + recordMetadata.offset());
                         } else {
                         LOG.error("Error while producing", exception);
                     }
                 }
            });
        });
    }
}
