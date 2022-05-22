package com.payment.kafka.config;

public class ConsumerConfigurations {

        public static final String KAFKA_BROKERS = "localhost:9092";

        public static final Integer MESSAGE_COUNT=1000;

        public static final String CLIENT_ID="1";

        public static final String TOPIC_NAME="UPI";

        public static final String GROUP_ID_CONFIG="1";

        public static final Integer MAX_NO_MESSAGE_FOUND_COUNT=1000;

        public static final String OFFSET_RESET_LATEST="latest";

        public static final Integer MAX_POLL_RECORDS=1;

}
