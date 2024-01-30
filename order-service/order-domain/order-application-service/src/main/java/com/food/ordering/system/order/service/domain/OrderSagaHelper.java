package com.food.ordering.system.order.service.domain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.food.ordering.system.domain.exception.DomainException;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderSagaHelper {
    private final OrderRepository orderRepository;

    public OrderSagaHelper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(String orderId) {

        Optional<Order> orderResponse = orderRepository.findById(new OrderId(UUID.fromString(orderId)));
        if (orderResponse.isEmpty()) {
            log.error("Order with id: {} could not be found!", orderId);
            throw new DomainException("Order with id: " + orderId + " could not be found!");
        }

        return orderResponse.get();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
