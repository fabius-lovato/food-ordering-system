package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    private Customer(Builder builder) {
        super.setId(builder.customerId);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CustomerId customerId;

        private Builder() {
        }

        public Customer build() {
            return new Customer(this);
        }

        public Builder customerId(CustomerId customerId) {
            this.customerId = customerId;
            return this;
        }

    }
}
