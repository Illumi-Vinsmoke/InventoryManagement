package com.inventoryManagement.serviceInterface;

import java.util.List;
import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.UserModel;
import com.inventoryManagement.model.UserRoleMapping;
/**
 * @Description:Login Service Interface for User Related Operations.
 * @ClassName: LoginServiceInterface
 * @author shubhams11
 * @Date:20-04-2022
 */
public interface LoginServiceInterface {

	public UserModel saveUser(UserModel user);
	public void deleteUser(Integer userId);
	public void updateUser(UserModel user);
	public UserModel findUser(Integer id)throws RecordNotFoundException ;
	public List<UserModel>findAllUser();
	public UserModel login(String User,String passsword);
	public List<UserRoleMapping> findRoleUsers();
	Integer findRole(Integer id);
}
