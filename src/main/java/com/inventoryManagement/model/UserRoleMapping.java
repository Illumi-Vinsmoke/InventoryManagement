package com.inventoryManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * @Description: User and role mapping class for maping data of user with role table.
 * @ClassName: UserRoleMapping
 * @author shubhams11
 * @Date:20-04-2022
 */
@Entity
public class UserRoleMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	@JoinColumn
	private UserModel user;

	@OneToOne
	@JoinColumn
	private RoleModel role;

	public Integer getId() {
		return id;
	}

	//Setters and Getters
	public void setId(Integer id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	// Constructor with argument.
	public UserRoleMapping(UserModel user, RoleModel role) {
		super();
		this.user = user;
		this.role = role;
	}

	// Non argument constructor
	public UserRoleMapping() {
		super();
		
	}

	@Override
	public String toString() {
		return "UserRoleMapping [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
	
	// to string method.
	
}
