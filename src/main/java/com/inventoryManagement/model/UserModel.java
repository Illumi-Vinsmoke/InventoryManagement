package com.inventoryManagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * @Description: User class for taking data of user type.
 * @ClassName: UserModel
 * @author shubhams11
 * @Date:20-04-2022
 */
@Component
@Entity
public class UserModel {

	// variables to take user details like name username password email and contact
	// number.
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String userName;
	private String password;
	private String email;
	private Long conactNo;
    
	@Transient
	private Integer roleId;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getConactNo() {
		return conactNo;
	}

	public void setConactNo(Long conactNo) {
		this.conactNo = conactNo;
	}

	public Integer getRoleId() {
		return roleId;
	}

	// Constructor with Argument.
	public UserModel(String name, Long id, String userName, String password, String email, Long conactNo,
			Integer roleId) {
		super();
		this.name = name;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.conactNo = conactNo;
		this.roleId = roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	// Non argument constructor.
	public UserModel() {
		super();
	}
	//To String method overload.

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", conactNo=" + conactNo + ", roleId=" + roleId + "]";
	}
	

}
