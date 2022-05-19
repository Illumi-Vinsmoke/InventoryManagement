package com.inventoryManagement.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.CustomerModel;
import com.inventoryManagement.repository.CustomerRepository;
import com.inventoryManagement.serviceInterface.CustomerServiceInterface;


/**
 * @Description: Customer Service Implementation class to implement methods describe in customer Service.
 * @ClassName: CustomerServiceInterface
 * @author shubhams11
 * @Date:04-05-2022
 */
@Service
public class CustomerServiceImplementation implements CustomerServiceInterface{
	@Autowired
	CustomerRepository customerRepository;
	
	/**
	 * @Description: Save new record.
	 * @Methodname:  saveCustomer
	 */
	@Override
	public String  saveCustomer(CustomerModel customer){
		customerRepository.save(customer);
		return "Saved Succesfully";
		}

	/**
	 * @Description: Delete record in database from customer table.
	 * @Methodname:  deleteCustomer
	 */
	@Override
	public String deleteCustomer(Long customerId){
		customerRepository.deleteById(customerId);
		return "";
		}

	/**
	 * @Description: Update record in customer table.
	 * @Methodname:  updateCustomer
	 */
	@Override
	public String updateCustomer(CustomerModel customer){
		Optional<CustomerModel> oldCustomerData=customerRepository.findById(customer.getId());
		if(oldCustomerData.isPresent()) {
			CustomerModel tempCustomer=oldCustomerData.get();
			if(customer.getName()==null||customer.getName().isEmpty()) {
				customer.setName(tempCustomer.getName());
			}
			if(customer.getConactNo()==null) {
				customer.setConactNo(tempCustomer.getConactNo());
			}
			if(customer.getEmail()==null||customer.getName().isEmpty()) {
				customer.setEmail(tempCustomer.getEmail());
			}
			if(customer.getAddress()==null||customer.getAddress().isEmpty()) {
				customer.setAddress(tempCustomer.getAddress());
			}
			customerRepository.save(customer);
		}
		return "Updated Succesfully";
	}

	/**
	 * @Description: Find record in customer table.
	 * @Methodname:  findCustomer
	 */
	@Override
	public CustomerModel findCustomer(Long id) throws RecordNotFoundException {
		Optional<CustomerModel> customerOptional=customerRepository.findById(id);
		CustomerModel customer = null;
		if (customerOptional.isPresent()) {
			customer = customerOptional.get();
		} else {
			throw new RecordNotFoundException("Record doesn't exist");
		}
		return customer;
		}

	/**
	 * @Description: Find all record in customer table.
	 * @Methodname:  findAllCustomer
	 */
	@Override
	public List<CustomerModel> findAllcustomer(){
		List<CustomerModel> customerModel=customerRepository.findAll();
		return customerModel;
		}
}
