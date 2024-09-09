package com.order.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OderProducer {
    private final KafkaTemplate<String, OderConfirmation> kafkaTemplate;
    public void sendOrderConfirmation(OderConfirmation oderConfirmation){
        log.info("sending order confirmation");
        Message<OderConfirmation> message = MessageBuilder
                .withPayload(oderConfirmation)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
