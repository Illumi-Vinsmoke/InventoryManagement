/**
 *@Descritpion: Interface for user role mapping repository.
 *@IntefaceName:UserRoleMappingRepository
 *@author shubhams11
 *@Date 21-04-2022
 */
package com.inventoryManagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventoryManagement.model.UserRoleMapping;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Integer> {

	// creating native query for finding role of given Id.
	@Query(value="SELECT * FROM user_role_mapping where  user_id=?1",nativeQuery=true)
	 UserRoleMapping roleId(Integer user_id);
	
	// creating native query for delete data without primary key in database.
	@Modifying
	@Transactional
	@Query(value="DELETE FROM user_role_mapping WHERE user_id=?1",nativeQuery=true)
	void remove(Integer user_id);
}
