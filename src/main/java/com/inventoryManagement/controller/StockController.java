package com.inventoryManagement.controller;

/**
 * @Description: Customer Controller class to implement methods describe in customer Service.
 * @ClassName: CustomerServiceInterface
 * @author shubhams11
 * @Date:04-05-2022
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.StockModel;
import com.inventoryManagement.serviceInterface.StockServiceInterface;

@Controller
public class StockController {

	@Autowired
	StockServiceInterface stockService;

	// Form to save stock into database.
	@GetMapping("/saveStockForm")
	public String saveForm() {
		return "StockForm";
	}

	// Saving new stock into database.
	@PostMapping("/saveStock")
	public ResponseEntity<String> saveStock(@ModelAttribute StockModel stock) {
		stockService.saveStock(stock);
		ResponseEntity<String> message = new ResponseEntity<String>("Saved Successfully", HttpStatus.OK);
		return message;
	}

	// form to update stock into database.
	@GetMapping("/stockUpdateForm/{id}")
	public String updateStock(@PathVariable(value = "id") Long stockId, Model model) throws RecordNotFoundException {
		StockModel stock = stockService.findStock(stockId);
		model.addAttribute("Stock", stock);
		return "StockUpdate";
	}

	// Updating stock into database.
	@PostMapping("/updateStock")
	public ResponseEntity<String> updatingStock(@ModelAttribute StockModel stock, HttpServletResponse response)
			throws IOException {
		stockService.updateStock(stock);
		ResponseEntity<String> message = new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		return message;
	}

	// To delete stock into database.
	@GetMapping("/deleteStock/{id}")
	public ResponseEntity<String> deleteStock(@PathVariable(value = "id") Long stockId) {
		stockService.deleteStock(stockId);
		ResponseEntity<String> message = new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		return message;
	}

	// Find stock By Id From database.
	@GetMapping("/findstock")
	public ResponseEntity<StockModel> findStock(@RequestParam(name = "id") Long stockId, Model model)
			throws RecordNotFoundException {
		StockModel stock = stockService.findStock(stockId);
		model.addAttribute("records", stock);
		ResponseEntity<StockModel> message = new ResponseEntity<StockModel>(stock, HttpStatus.OK);
		return message;
	}
	// find Stock by Name
	@GetMapping("/findstockByName")
	public ResponseEntity<StockModel> findStockByName(@RequestParam(name = "name") String stockName, Model model)
			throws RecordNotFoundException {
		System.out.println("unser findStockByName");
		StockModel stock = stockService.findStockByName(stockName);
		//model.addAttribute("records", stock);
		ResponseEntity<StockModel> responseStock = new ResponseEntity<StockModel>(stock, HttpStatus.OK);
		return responseStock;
	}

	// find All stock record
	@GetMapping("/findAllStock")
	public String findAllStock(Model model) {
		List<StockModel> records = stockService.findAllStock();
		model.addAttribute("records", records);
		return "FindAllStock";

	}
	
}
