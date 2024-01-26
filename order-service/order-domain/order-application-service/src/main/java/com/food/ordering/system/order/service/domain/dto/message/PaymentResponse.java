package com.food.ordering.system.order.service.domain.dto.message;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.food.ordering.system.domain.valueobject.PaymentStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {

    @NotNull
    private String id;

    private String sagaId;

    @NotNull
    private String orderId;

    @NotNull
    private String paymentId;

    @NotNull
    private String customerId;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Instant createdAt;

    @NotNull
    private PaymentStatus paymentStatus;

    private List<String> failureMessages;
}
