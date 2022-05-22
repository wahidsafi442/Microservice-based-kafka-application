package com.payment.kafka.consumer;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.kafka.consumer.PaymentFactory;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<PaymentFactory> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public PaymentFactory deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), PaymentFactory.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to payment");
        }
    }

    @Override
    public void close() {
    }
}
