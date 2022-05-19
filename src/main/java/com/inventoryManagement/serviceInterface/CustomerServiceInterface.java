package com.inventoryManagement.serviceInterface;

import java.util.List;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.CustomerModel;

/**
 * @Description: Customer Service Interface.
 * @ClassName: CustomerServiceInterface
 * @author shubhams11
 * @Date:04-05-2022
 */
public interface CustomerServiceInterface {

	public String  saveCustomer(CustomerModel customer);
	public String deleteCustomer(Long customerId);
	public String updateCustomer(CustomerModel customer);
	public CustomerModel findCustomer(Long id) throws RecordNotFoundException;
	public List<CustomerModel> findAllcustomer();
}
