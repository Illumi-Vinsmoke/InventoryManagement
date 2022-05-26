package com.inventoryManagement.serviceImplementation;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventoryManagement.dto.BillDTO;
import com.inventoryManagement.dto.OrderReport;
import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
import com.inventoryManagement.repository.OrderRepository;
import com.inventoryManagement.repository.SaleRepository;
import com.inventoryManagement.serviceInterface.OrderServiceInterface;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * @Description: service class for OrderModel
 * @ClassName:OrderServiceImplementation
 * @author: shubhams11
 */
@Service
public class OrderServiceImplementation implements OrderServiceInterface {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	SaleRepository saleRepository;
	@Override
	public void saveOrder(OrderModel order) {
		orderRepository.save(order);

	}

	/*
	 * To delete order by given Id
	 */
	@Override
	public String deleteOrder(Long orderId) {
	Optional<OrderModel> order= orderRepository.findById(orderId);
	if(order.isPresent()) {
		saleRepository.deleteByOrderId(orderId);
		orderRepository.deleteById(orderId);
		return "Deleted SucessFully";
	}
     return "Order Not present";
	}

	@Override
	public OrderModel findOrder(Long orderId) throws RecordNotFoundException {
		Optional<OrderModel> order= orderRepository.findById(orderId);
		if(order.isPresent()) 
			return order.get();
		return null;
	}
	
	public Long findOrder() {
       Long orderId= orderRepository.findOrder();
		return orderId;
	}

	@Override
	public List<OrderModel> findAllOrder() {
		List<OrderModel> orderRecords=orderRepository.findAll(); 
		return orderRecords;
	}

	
	@Override
	public JasperPrint getPoConfirmationReport(Long orderId) throws JRException {
		JasperPrint jasperPrint = null;
		Map<String, Object> param = new HashMap<>();
		InputStream jasperStream = getClass().getClassLoader().getResourceAsStream("Report/Invoice.jrxml");
		JasperDesign design = JRXmlLoader.load(jasperStream);
        
		Optional<OrderModel> order= orderRepository.findById(orderId);
		OrderModel order1=order.get();
		List<SalesModel> sales=saleRepository.findByOrderId(orderId);		
		OrderReport entity[] =new OrderReport[sales.size()] ; 
		List<OrderReport> data = new ArrayList<>();
		int index=0;
		for(SalesModel store: sales) {
			entity[index]=new OrderReport();
			entity[index].setAddress(order.get().getAddress());
			entity[index].setCustomercontactNo(String.valueOf(order.get().getCustomercontactNo()));
			entity[index].setCustomerName(order.get().getCustomerName());
			entity[index].setDate(String.valueOf(order.get().getDate()));
			entity[index].setGst(String.valueOf(order.get().getGst()));
			entity[index].setProductDiscount(String.valueOf(store.getDiscount()));
			entity[index].setProductName(store.getProductName());
			entity[index].setProductDiscount(String.valueOf(store.getDiscount()));
			entity[index].setProductQuantity(String.valueOf(store.getQuantity()));
			entity[index].setPayblePrice(String.valueOf(store.getPaybleAmount()));
			entity[index].setMarkedPrice(String.valueOf(store.getActualPrice()));
			entity[index].setSno(store.getSNo());
			entity[index].setTotalDiscount(String.valueOf(store.getDiscount()));
			entity[index].setTotalGst(String.valueOf(order.get().getTotalGst()));
			entity[index].setTotalPrice(String.valueOf(order.get().getTotalbill()));
			entity[index].setTotalDiscount(String.valueOf(order.get().getTotalDiscount()));
			data.add(entity[index]);
			index++;
		}
		
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(data);
		param.put("datasource", jrDataSource);
		JasperReport report = JasperCompileManager.compileReport(design);
		jasperPrint = JasperFillManager.fillReport(report, param, jrDataSource);
		jasperPrint.setProperty("reportName", "orderReport.pdf");
		return jasperPrint;
	}

	@Override
	public Set<SalesModel> setValue(BillDTO bill) {
		
		
		OrderModel order=new OrderModel();
		SalesModel sales[]=new SalesModel[bill.getSNo().length];
		Set<SalesModel> salesSet=new HashSet<SalesModel>();  
		order.setAddress(bill.getAddress());
		order.setCustomercontactNo(bill.getCustomercontactNo());
		order.setCustomerName(bill.getCustomerName());
		try {
			Date date=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(bill.getDate());
			order.setDate(date);
			}catch(ParseException e) {
				System.out.println(e);	
			}
		
		order.setGst(bill.getGst());
		order.setTotalbill(bill.getTotalPrice());
		order.setTotalDiscount(bill.getTotalDiscount());
		order.setTotalGst(bill.getTotalGst());
		for(int index=0;index<bill.getSNo().length;index++) {
			sales[index]=new SalesModel();
			sales[index].setActualPrice(bill.getActualPrice(index));
			sales[index].setPaybleAmount(bill.getPaybleAmount(index));
			sales[index].setDiscount(bill.getDiscount(index));
			sales[index].setProductName(bill.getProductName(index));
			sales[index].setQuantity(bill.getQuantity(index));
			sales[index].setSNo(bill.getSNo(index));
			sales[index].setOrder(order);
			salesSet.add(sales[index]);
		}
		orderRepository.save(order);
		saleRepository.saveAll(salesSet);
		return salesSet;
	}
}
