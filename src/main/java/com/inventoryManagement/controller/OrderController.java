package com.inventoryManagement.controller;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
import com.inventoryManagement.serviceInterface.OrderServiceInterface;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class OrderController {
	@Autowired
	private OrderServiceInterface orderService;
	
	@GetMapping("/Billing")
	public String Test() {				
	return "BillingPage";
	}
	@GetMapping("/billGeneration")
	public String generate(@ModelAttribute OrderModel order, @RequestParam("sno") List<Integer> sno/*,@RequestParam("name[]")String name[],@RequestParam("price[]") Float price[],@RequestParam("discount[]") Float discount[],@RequestParam("quantity[]") Integer quantity[],@RequestParam("total[]") Float amount[],@RequestParam Integer total,@RequestParam Float totaldiscount ,@RequestParam Float totalGst*/ ) {
		/*
		 * Set<SalesModel> salesSet=new HashSet<SalesModel>(); SalesModel sales=new
		 * SalesModel();
		 */
		System.out.println("sno is:"+ sno);
		/*
		 * for(int index=0;index<sno.length;index++) {
		 * sales.setActualPrice(price[index]); sales.setDiscount(discount[index]);
		 * sales.setPaybleAmount(amount[index]); sales.setProductName(name[index]);
		 * sales.setQuantity(quantity[index]); sales.setSno(sno[index]);
		 * salesSet.add(sales); }
		 */
		//order.setSale(salesSet);
	 	//orderService.saveOrder(order);
	 return "Its Working";
	}
	
	@GetMapping("/export/{format}")
	public String exportReport(@PathVariable(value="format") String format,@ModelAttribute OrderModel order) throws FileNotFoundException, JRException {
		return orderService.exportReport(format,order);
	}
	
	
	@GetMapping("/report/poConfirmation/{poId}")
    public String getPoConfirmationReport(@PathVariable("poId") Integer poId) {
          try {

               JasperPrint jasperPrint = orderService.getPoConfirmationReport((long)poId);

               String fileName = poId + "-" + System.currentTimeMillis() + jasperPrint.getProperty("reportName");
               JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/reports/" + fileName);
            //   return new ResponseEntity<>(new ResponseDTO(ReportNameConstant.PO_CONFIRMATION, fileName), HttpStatus.CREATED);
          } catch (JRException e) {
              // return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
          }
		return null;
    }

	

}
