/**
 *@Descritpion: Interface for user repository.
 *@IntefaceName:UserRepository
 *@author shubhams11
 *@Date 18-04-2022
 */
package com.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventoryManagement.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long > {

	// creating native query for Matching User name and password in database.
		@Query(value="Select * from User_model  where user_name = ?1 and password=?2",nativeQuery=true)
		UserModel loginUser(String userName,String password);
	
		
}
