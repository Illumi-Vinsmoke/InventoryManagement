package com.inventoryManagement.serviceImplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
import com.inventoryManagement.reportDTO.OrderReport;
import com.inventoryManagement.repository.OrderRepository;
import com.inventoryManagement.repository.SaleRepository;
import com.inventoryManagement.serviceInterface.OrderServiceInterface;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
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

	@Override
	public String deleteOrder(Long orderId) {
	Optional<OrderModel> order= orderRepository.findById(orderId);
	if(order.isPresent()) {
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

	@Override
	public List<OrderModel> findAllOrder() {
		List<OrderModel> orderRecords=orderRepository.findAll(); 
		return orderRecords;
	}
	
	@Override
	public String exportReport(String format, OrderModel order) throws FileNotFoundException, JRException  {
		List<OrderModel> orderList=new ArrayList<OrderModel>();
		orderList.add(order);
		String path="C://Users//shubhams11//Documents";
		File file=ResourceUtils.getFile("src/main/webapp/WEB-INF/views/Invoice.jrxml");
		JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(orderList);
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("gain Java","Knowledge");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,parameters, dataSource);
		if(format.equalsIgnoreCase("Html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path +"Invoice.html" );
		}
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,path +"Invoice.pdf" );
		}
		
		return "path:"+ path;
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
		OrderReport entity = new OrderReport();
		List<OrderReport> data = new ArrayList<>();
		for(SalesModel store: sales) {
			System.out.println("Product price: "+ store.getPaybleAmount());
			entity.setAddress(order.get().getAddress());
			entity.setCustomercontactNo(String.valueOf(order.get().getCustomercontactNo()));
			entity.setCustomerName(order.get().getCustomerName());
			entity.setDate(String.valueOf(order.get().getDate()));
			entity.setGst("18");
			entity.setProductDiscount(String.valueOf(store.getDiscount()));
			entity.setProductName(store.getProductName());
			entity.setProductDiscount(String.valueOf(store.getDiscount()));
			entity.setProductQuantity(String.valueOf(store.getQuantity()));
			entity.setPayblePrice(String.valueOf(store.getPaybleAmount()));
			entity.setMarkedPrice(String.valueOf(store.getActualPrice()));
			entity.setSno(store.getSno());
			entity.setTotalDiscount(String.valueOf(store.getDiscount()));
			entity.setTotalGst(String.valueOf(order.get().getTotalGst()));
			entity.setTotalPrice(String.valueOf(order.get().getTotalbill()));
			entity.setTotalDiscount(String.valueOf(order.get().getTotalDiscount()));
			data.add(entity);
		}
		
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(data);
		param.put("datasource", jrDataSource);
		JasperReport report = JasperCompileManager.compileReport(design);
		jasperPrint = JasperFillManager.fillReport(report, param, jrDataSource);
		jasperPrint.setProperty("reportName", "orderReport.pdf");
		return jasperPrint;
	}

}
