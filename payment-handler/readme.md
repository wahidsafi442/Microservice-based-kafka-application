Micro service based kafka application

Payment-handler: (Kafka-Producer)

It handles the incoming payment request for different types of payment mode.

Each payment type have it's own topic.

It renders json inputs and push the messages in to the topic.

Each consumers run independently to form microservice based application.

