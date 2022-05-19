package com.inventoryManagement.controller;
/**
 * @Description: Customer Controller class to implement methods describe in customer Service.
 * @ClassName: CustomerServiceInterface
 * @author shubhams11
 * @Date:04-05-2022
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.CustomerModel;
import com.inventoryManagement.model.UserModel;
import com.inventoryManagement.serviceInterface.CustomerServiceInterface;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceInterface customerService;

	// Form to save customer into database.
	@GetMapping("/saveCustomerForm")
	public String saveForm() {
		return "CustomerForm";
	}
	
	//Saving new customer into database.
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@ModelAttribute CustomerModel customer) {
		customerService.saveCustomer(customer);
		ResponseEntity<String> message=new ResponseEntity<String>("Saved Successfully",HttpStatus.OK);
	  return message;
	}
	
	//form to update customer into database.
	@GetMapping("/customerUpdateForm/{id}")
	public String updateCustomer(@PathVariable(value ="id") Long customerId, Model model) throws RecordNotFoundException {
		CustomerModel customer=customerService.findCustomer(customerId);
		 model.addAttribute("User",customer);
		return"CustomerUpdateForm";
	}
	//Updating customer into database.
	@PostMapping("/updateCustomer")
	public ResponseEntity<String> updatingCustomer(@ModelAttribute CustomerModel cutomer,HttpServletResponse response) throws IOException {
		customerService.updateCustomer(cutomer);
		ResponseEntity<String> message=new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
		  return message;
	}
	//To delete customer into database.
	@GetMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable (value="id") Long id) {
		customerService.deleteCustomer(id);
		ResponseEntity<String> message=new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		return message;
	}
	
	//Find customer From database.
	@GetMapping("/findcustomer")
		public ResponseEntity<CustomerModel> findCustomer(@RequestParam(name ="id") Long customerId, Model model) throws RecordNotFoundException {
			CustomerModel customer=customerService.findCustomer(customerId);
			 model.addAttribute("records",customer);
			 ResponseEntity<CustomerModel> message=new ResponseEntity<CustomerModel>(customer,HttpStatus.OK);
			 return message;
		}
	
	// find All customer record
	@GetMapping("/findAllCustomer")
	public String findAllCustomer(Model model){
		List<CustomerModel> records=customerService.findAllcustomer();
		model.addAttribute("records",records);
		 ResponseEntity<List<CustomerModel>> message=new ResponseEntity<List<CustomerModel>>(records,HttpStatus.OK);
		 return "findAllCustomer";
		
	}
}
