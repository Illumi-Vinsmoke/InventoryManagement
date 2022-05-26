package com.inventoryManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.inventoryManagement.model.OrderModel;

/**
 * @Description Repository class for Order Model
 * @ClassName OrderRepository
 * @author shubhams11
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
	@Query
	(value="select max(order_id) from order_model",nativeQuery=true)
	Long findOrder();
}
