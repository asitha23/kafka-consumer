package com.kafka.consumer.service;

import com.kafka.consumer.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-updates-topic", groupId = "order-group", filter = "shippedFilter")
    public void consume(OrderEvent event) {
        println("Received Update: " + event.orderId() + " is now " + event.status());

        switch (event.status()) {
            case SHIPPED -> println("Notify customer!");
            case DELIVERED -> println("Close ticket.");
            default -> println("Monitoring...");
        }
    }
}