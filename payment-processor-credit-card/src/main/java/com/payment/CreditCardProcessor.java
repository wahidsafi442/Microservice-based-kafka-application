package com.payment;
import com.payment.kafka.config.ConsumerConfigurations;
import com.payment.kafka.consumer.ConsumerCreator;
import com.payment.kafka.consumer.PaymentFactory;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CreditCardProcessor {

    public static final Logger LOG = LoggerFactory.getLogger(CreditCardProcessor.class);

    public static void main(String[] args) {

       runConsumer();
    }

    static void runConsumer() {
        Consumer<String, PaymentFactory> consumer = ConsumerCreator.createConsumer();

        LOG.info("Kafka consumer is running");

        int noMessageFound = 0;

        while (true) {
            ConsumerRecords<String, PaymentFactory> consumerRecords = consumer.poll(Duration.ofMillis(100));
            // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
      /*      if (consumerRecords.count() == 0) {
                noMessageFound++;
                if (noMessageFound > ConsumerConfigurations.MAX_NO_MESSAGE_FOUND_COUNT)
                {
                    LOG.warn("Consumer threshold reached");
                    break;
                }
                else
                    continue;
            }*/

            //print each record.
            consumerRecords.forEach(record -> {
                LOG.info("Record Key " + record.key() + "Record value " + record.value() +
                         "Record partition " + record.partition() +
                        "Record offset " + record.offset());

                System.out.println("Record Key " + record.key() + "Record value " + record.value() +
                        "Record partition " + record.partition() +
                        "Record offset " + record.offset());
            });

            // commits the offset of record to broker.
            consumer.commitAsync();
        }
    }
}
