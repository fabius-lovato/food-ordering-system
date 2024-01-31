package com.food.ordering.system.order.service.messaging.mapper;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.food.ordering.system.kafka.order.avro.model.PaymentOrderStatus;
import com.food.ordering.system.kafka.order.avro.model.PaymentRequestAvroModel;
import com.food.ordering.system.kafka.order.avro.model.PaymentResponseAvroModel;
import com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.food.ordering.system.kafka.order.avro.model.RestaurantOrderStatus;
import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.food.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalEventPayload;
import com.food.ordering.system.order.service.domain.outbox.model.payment.OrderPaymentEventPayload;

@Component
public class OrderMessagingDataMapper {

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel paymentResponseAvroModel) {
        UUID sagaId = paymentResponseAvroModel.getSagaId();
        return PaymentResponse.builder()
                .id(paymentResponseAvroModel.getId().toString())
                .sagaId(Objects.isNull(sagaId) ? null : sagaId.toString())
                .paymentId(paymentResponseAvroModel.getPaymentId().toString())
                .customerId(paymentResponseAvroModel.getCustomerId().toString())
                .orderId(paymentResponseAvroModel.getOrderId().toString())
                .price(paymentResponseAvroModel.getPrice())
                .createdAt(paymentResponseAvroModel.getCreatedAt())
                .paymentStatus(com.food.ordering.system.domain.valueobject.PaymentStatus.valueOf(
                        paymentResponseAvroModel.getPaymentStatus().name()))
                .failureMessages(paymentResponseAvroModel.getFailureMessages())
                .build();
    }

    public RestaurantApprovalResponse approvalResponseAvroModelToApprovalResponse(
            RestaurantApprovalResponseAvroModel restaurantApprovalResponseAvroModel
    ) {
        UUID sagaId = restaurantApprovalResponseAvroModel.getSagaId();
        return RestaurantApprovalResponse.builder()
                .id(restaurantApprovalResponseAvroModel.getId().toString())
                .sagaId(Objects.isNull(sagaId) ? null : sagaId.toString())
                .restaurantId(restaurantApprovalResponseAvroModel.getRestaurantId().toString())
                .orderId(restaurantApprovalResponseAvroModel.getOrderId().toString())
                .createdAt(restaurantApprovalResponseAvroModel.getCreatedAt())
                .orderApprovalStatus(com.food.ordering.system.domain.valueobject.OrderApprovalStatus.valueOf(
                        restaurantApprovalResponseAvroModel.getOrderApprovalStatus().name()))
                .failureMessages(restaurantApprovalResponseAvroModel.getFailureMessages())
                .build();
    }

    public PaymentRequestAvroModel orderPaymentEventToPaymentRequestAvroModel(String sagaId, OrderPaymentEventPayload orderPaymentEventPayload) {
        return PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setCustomerId(UUID.fromString(orderPaymentEventPayload.getCustomerId()))
                .setOrderId(UUID.fromString(orderPaymentEventPayload.getOrderId()))
                .setPrice(orderPaymentEventPayload.getPrice())
                .setCreatedAt(orderPaymentEventPayload.getCreatedAt().toInstant())
                .setPaymentOrderStatus(PaymentOrderStatus.valueOf(orderPaymentEventPayload.getPaymentOrderStatus()))
                .build();
    }

    public RestaurantApprovalRequestAvroModel orderApprovalEventToRestaurantApprovalRequestAvroModel(
            String sagaId, OrderApprovalEventPayload orderApprovalEventPayload
    ) {
        return RestaurantApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setOrderId(UUID.fromString(orderApprovalEventPayload.getOrderId()))
                .setRestaurantId(UUID.fromString(orderApprovalEventPayload.getRestaurantId()))
                .setRestaurantOrderStatus(RestaurantOrderStatus
                        .valueOf(orderApprovalEventPayload.getRestaurantOrderStatus()))
                .setProducts(orderApprovalEventPayload.getProducts().stream().map(orderApprovalEventProduct ->
                        com.food.ordering.system.kafka.order.avro.model.Product.newBuilder()
                                .setId(orderApprovalEventProduct.getId())
                                .setQuantity(orderApprovalEventProduct.getQuantity())
                                .build()).collect(Collectors.toList()))
                .setPrice(orderApprovalEventPayload.getPrice())
                .setCreatedAt(orderApprovalEventPayload.getCreatedAt().toInstant())
                .build();
    }

}
