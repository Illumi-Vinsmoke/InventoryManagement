package com.inventoryManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * @Description: Customer class for taking data of Customer type.
 * @ClassName: CustomerModel
 * @author shubhams11
 * @Date:04-05-2022
 */
@Entity
public class CustomerModel {

	// variables to take user details like name customer name email and contact
	// number.
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String address;
	private Long conactNo;
    
	//Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getConactNo() {
		return conactNo;
	}

	public void setConactNo(Long conactNo) {
		this.conactNo = conactNo;
	}

	// Constructor with Argument.
	public CustomerModel(String name, Long id, String email,String address, Long conactNo) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.conactNo = conactNo;
		this.address=address;
	}

	// Non argument constructor.
	public CustomerModel() {
		super();
	}
	//To String method overload.

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", id=" + id + ", email=" + email + ", Address="+ address+ ",conactNo=" + conactNo + "]";
	}
	

}
