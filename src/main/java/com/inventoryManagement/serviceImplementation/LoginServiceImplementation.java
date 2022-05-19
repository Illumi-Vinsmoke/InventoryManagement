package com.inventoryManagement.serviceImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.RoleModel;
import com.inventoryManagement.model.UserModel;
import com.inventoryManagement.model.UserRoleMapping;
import com.inventoryManagement.repository.RoleRepository;
import com.inventoryManagement.repository.UserRepository;
import com.inventoryManagement.repository.UserRoleMappingRepository;
import com.inventoryManagement.serviceInterface.LoginServiceInterface;

/**
 * @Description: This Service class is to implement logics about login,
 *               registrations, update, find and delete using various roles. It
 *               implements login service interface.
 * @className: LoginServiceImplementation
 * @author shubhams11
 */

@Service
public class LoginServiceImplementation implements LoginServiceInterface {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	UserRoleMappingRepository userRoleMappingRepository;

//Save Method to save data.
	@Override
	public UserModel saveUser(UserModel userModel) {
		UserModel result = userRepo.save(userModel);
		Optional<RoleModel> role = roleRepository.findById(userModel.getRoleId());
		if (role.isPresent()) {
			UserRoleMapping userRole = new UserRoleMapping(result, role.get());
			userRoleMappingRepository.save(userRole);
		}
		return result;

	}

	/**
	 * @description:Update method it will fetch data first from database and replace
	 *                     null field with existing record and then update field.
	 * @methodName: updateUser;
	 */
	@Override
	public void updateUser(UserModel user) {

		try {
			UserModel userTemp = findUser((user.getId().intValue()));

			if (user.getName() == null || user.getName().isEmpty())

				user.setName(userTemp.getName());

			if (user.getUserName() == null || user.getUserName().isEmpty())
				user.setUserName(userTemp.getUserName());

			if (user.getPassword() == null || user.getPassword().isEmpty())
				user.setPassword(userTemp.getPassword());
			if (user.getEmail() == null || user.getEmail().isEmpty())
				user.setName(userTemp.getName());

			if (user.getRoleId() == 0)

				user.setUserName(userTemp.getUserName());

			if (user.getConactNo() == 0)
				user.setPassword(userTemp.getPassword());

			Optional<RoleModel> role = roleRepository.findById(user.getRoleId());
			userRepo.save(user);
			
		} catch (RecordNotFoundException rec) {
			System.out.println("record not prnsent");
		}
	}

	/**
	 * @description:Find Method to fetch one record.
	 * @methodName: findUser;
	 */
	@Override
	public UserModel findUser(Integer id) throws RecordNotFoundException {

		Optional<UserModel> user1 = userRepo.findById((long) id);

		UserModel user = null;
		if (user1.isPresent()) {
			user = user1.get();
		} else {
			throw new RecordNotFoundException("Record doesn't exist");
		}
		return user;

	}
	/**
	 * @description:Find Method to fetch All record.
	 * @methodName: findAllUser;
	 */
	@Override
	public List<UserModel> findAllUser() {

		List<UserModel> userModel=userRepo.findAll();
		List<UserRoleMapping> userRoleModel=userRoleMappingRepository.findAll();
		Iterator<UserModel> itrUser= userModel.iterator();
		Iterator<UserRoleMapping> itrRole= userRoleModel.iterator();
		for(;itrRole.hasNext() || itrUser.hasNext();)
				itrUser.next().setRoleId(itrRole.next().getRole().getRoleId());
		return userModel;
	}
	/**
	 * @description: Delete Method to delete one record.
	 * @methodName: deleteUser;
	 */
	@Override
	public void deleteUser(Integer id) {
		Long longId=(long)id;
		userRoleMappingRepository.remove(id);
		userRepo.deleteById(longId);

	}

//Method To check login credentials.
	@Override
	public UserModel login(String User, String passsword) {
		UserModel result = new UserModel();
		result = userRepo.loginUser(User, passsword);
		System.out.println(result);
		// if user name and password is present it will check for role and set role.
		if (result != null) {
			UserRoleMapping userRole = userRoleMappingRepository.roleId(result.getId().intValue());
			result.setRoleId(userRole.getRole().getRoleId());
			return result;
		} else
			return null;
	}

	//Find All Roles
	@Override
	public List<UserRoleMapping> findRoleUsers() {
		return userRoleMappingRepository.findAll();
	}
	@Override
	// find role using ID
	public Integer findRole( Integer id) {
		UserRoleMapping userRole = userRoleMappingRepository.roleId(id);
		return userRole.getRole().getRoleId();
			
	}

}
