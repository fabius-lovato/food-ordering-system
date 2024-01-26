package com.food.ordering.system.restaurant.service.dataaccess.restaurant.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.ordering.system.restaurant.service.dataaccess.restaurant.entity.OrderApprovalEntity;

@Repository
public interface OrderApprovalJpaRepository extends JpaRepository<OrderApprovalEntity, UUID> {


}
