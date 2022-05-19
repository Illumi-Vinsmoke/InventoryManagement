package com.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryManagement.model.CustomerModel;
/**
 * @Description: CustomerRepository Interface.
 * @ClassName: CustomerRepository
 * @author shubhams11
 * @Date:04-05-2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

}
