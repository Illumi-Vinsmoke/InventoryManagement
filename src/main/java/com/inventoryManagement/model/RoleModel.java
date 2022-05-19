package com.inventoryManagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Description: Role class for taking data of role type.
 * @ClassName: RoleModel
 * @author shubhams11
 * @Date:20-04-2022
 */
@Entity
public class RoleModel {
	
	@Id
	private Integer roleId;
	private String roleName;

	// Setters and Getters
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	// Constructor With argument

	public RoleModel(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// Non Argument Constructor
	public RoleModel() {
		super();
	}

}
