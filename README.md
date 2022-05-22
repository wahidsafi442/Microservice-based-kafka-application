Payment Handler:

It handles the incoming payment request for different types of payment mode.

Each payment type have it's own topic.

Kafka Producer: (Payment handler) It renders json inputs and push the messages in to the topic.

Kafka Consumers: Below modules are kafka consumers run independently to form microservice based application.
Each consumers listens to unique topic and process the message asynchronously.

1) Payment-processor-upi
2) Payment-processor-credit-card
3) payment-processor-pay-on-delivery




