package com.food.ordering.system.order.service.domain.dto.message;

import java.time.Instant;
import java.util.List;

import com.food.ordering.system.domain.valueobject.OrderApprovalStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {

    @NotNull
    private String id;

    @NotNull
    private String sagaId;

    @NotNull
    private String orderId;

    @NotNull
    private String restaurantId;

    @NotNull
    private Instant createdAt;

    @NotNull
    private OrderApprovalStatus orderApprovalStatus;

    private List<String> failureMessages;
}
