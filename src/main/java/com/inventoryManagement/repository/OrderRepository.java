package com.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventoryManagement.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
