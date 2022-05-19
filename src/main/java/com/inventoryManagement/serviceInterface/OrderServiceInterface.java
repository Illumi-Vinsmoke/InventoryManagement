package com.inventoryManagement.serviceInterface;

import java.io.FileNotFoundException;
import java.util.List;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.OrderModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface OrderServiceInterface {
	public void saveOrder(OrderModel order);
	public String deleteOrder(Long orderId);
	public OrderModel findOrder(Long orderId)throws RecordNotFoundException;
	public List<OrderModel> findAllOrder();
	String exportReport(String format, OrderModel order) throws FileNotFoundException, JRException;
	public JasperPrint getPoConfirmationReport(Long poId) throws JRException;
}
