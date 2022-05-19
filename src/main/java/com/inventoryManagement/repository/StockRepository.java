package com.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventoryManagement.model.StockModel;
/**
 * @description stock Repository to perform CURD operation on stocks inventory.
 * @IntefaceName StockRepository 
 * @author shubhams11
 * @Date 06-05-2022
 */
public interface StockRepository extends JpaRepository<StockModel, Long>{
	// creating native query for Matching User name and password in database.
			@Query(value="select * from stock_model where name=:name",nativeQuery=true)
			public StockModel findByName(String name);	
			

}
