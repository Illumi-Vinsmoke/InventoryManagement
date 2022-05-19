/**
 * @Description:Role Service Interface for role Related Operations.
 * @ClassName: RoleServiceInterface
 * @author shubhams11
 * @Date:20-04-2022
 */
package com.inventoryManagement.serviceInterface;

import java.util.List;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.RoleModel;

public interface RoleServiceInterface {
	public void save();
	public void delete();
	public void update();
	public RoleModel find() throws RecordNotFoundException;
	public List<RoleModel> findall();

}
