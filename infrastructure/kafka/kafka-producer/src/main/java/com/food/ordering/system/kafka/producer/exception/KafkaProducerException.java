package com.food.ordering.system.kafka.producer.exception;

public class KafkaProducerException extends RuntimeException {

    private static final long serialVersionUID = 8614007434939533887L;

    public KafkaProducerException(String message) {
        super(message);
    }
}
