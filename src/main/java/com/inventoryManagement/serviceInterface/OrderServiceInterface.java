package com.inventoryManagement.serviceInterface;

import java.util.List;
import java.util.Set;
import com.inventoryManagement.dto.BillDTO;
import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @Description: service Interface for OrderModel
 * @ClassName:OrderServiceInterface
 * @author: shubhams11
 */
public interface OrderServiceInterface {
	public void saveOrder(OrderModel order);
	public String deleteOrder(Long orderId);
	public OrderModel findOrder(Long orderId)throws RecordNotFoundException;
	public List<OrderModel> findAllOrder();
	public JasperPrint getPoConfirmationReport(Long poId) throws JRException;
	public Set<SalesModel> setValue(BillDTO bill);
	public Long findOrder();
}
