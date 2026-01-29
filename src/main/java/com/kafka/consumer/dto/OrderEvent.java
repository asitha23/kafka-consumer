package com.kafka.consumer.dto;

public record OrderEvent(String orderId, OrderStatus status) {}