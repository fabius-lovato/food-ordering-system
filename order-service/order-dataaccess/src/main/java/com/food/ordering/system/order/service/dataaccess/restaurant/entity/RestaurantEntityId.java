package com.food.ordering.system.order.service.dataaccess.restaurant.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntityId implements Serializable {

    private static final long serialVersionUID = 5954657376519613783L;

    private UUID restaurantId;

    private UUID productId;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        RestaurantEntityId other = (RestaurantEntityId) obj;
        return Objects.equals(productId, other.productId) && Objects.equals(restaurantId, other.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, restaurantId);
    }

}
