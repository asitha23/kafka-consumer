package com.kafka.consumer.config;

import com.kafka.consumer.dto.OrderEvent;
import com.kafka.consumer.dto.OrderStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

@Configuration
public class OrderFilterStrategy {

    @Bean
    public RecordFilterStrategy<Object, Object> shippedFilter() {

        return record -> {
            OrderEvent event = (OrderEvent) record.value();
            return !OrderStatus.SHIPPED.equals(event.status());

        };

    }
}