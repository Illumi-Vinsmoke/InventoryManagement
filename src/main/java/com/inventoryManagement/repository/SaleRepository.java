package com.inventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
@Repository
public interface SaleRepository extends JpaRepository<SalesModel,Long> {
	
	@Query(value="select * from sales_model where order_id=?1 ",nativeQuery=true)
	public List<SalesModel> findByOrderId(Long orderId);

}
