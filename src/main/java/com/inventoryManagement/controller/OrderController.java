package com.inventoryManagement.controller;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.inventoryManagement.dto.BillDTO;
import com.inventoryManagement.model.OrderModel;
import com.inventoryManagement.model.SalesModel;
import com.inventoryManagement.serviceInterface.OrderServiceInterface;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
/**
 * @description this controller is for handling billing and order records.
 * @className OrderController
 * @author shubhams11
 * @Date 10-05-2022
 */
@Controller
public class OrderController {
	@Autowired
	private OrderServiceInterface orderService;
	
	// to open billing page on front end.
	@GetMapping("/Billing")
	public String Test() {				
	return "BillingPage";
	}
	//To Save data in database for storing sales record.
	@PostMapping("/billGeneration")
	public RedirectView generate(@ModelAttribute BillDTO bill, Model model) {
		orderService.setValue(bill);
		Long poId=orderService.findOrder();
		 model.addAttribute("poId", poId);
	        return new RedirectView("/report/poConfirmation/"+poId);
	}
	
	@GetMapping("/report/poConfirmation/{poId}")
    public String getPoConfirmationReport(@PathVariable("poId") Integer poId,Model model) {
		String fileName=null;
          try {

               JasperPrint jasperPrint = orderService.getPoConfirmationReport((long)poId);

               fileName = poId + "-" + System.currentTimeMillis() + jasperPrint.getProperty("reportName");
               JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/reports/" + fileName);
            //   return new ResponseEntity<>(new ResponseDTO(ReportNameConstant.PO_CONFIRMATION, fileName), HttpStatus.CREATED);
          } catch (JRException e) {
              // return new ResponseEntity<>(new ResponseDTO(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
          }
          model.addAttribute("fileName", fileName);
		return "reciept";
    }

	

}
