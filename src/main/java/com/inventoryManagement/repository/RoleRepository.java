/**
 *@Descritpion: Interface for Role repository.
 *@IntefaceName:RoleRepository
 *@author shubhams11
 *@Date 19-04-2022
 */
package com.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryManagement.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Integer> {

}
