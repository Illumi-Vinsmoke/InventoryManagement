package com.inventoryManagement.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.StockModel;
import com.inventoryManagement.repository.StockRepository;
import com.inventoryManagement.serviceInterface.StockServiceInterface;

/**
 * @Description This class is to implement methods of service interface.
 * @ClassName StockServiceImplementation 
 * @author shubhams11
 * @date 06-05-2022
 */
@Service
public class StockServiceImplementation implements StockServiceInterface{

	@Autowired
	private StockRepository stockRepository;
	
	/**
	 * Save method to save new record in stock table
	 * Name saveStock
	 */
	@Override
	public void saveStock(StockModel stock) {		
	 stockRepository.save(stock);
	}
	
	/**
	 * Update method to Update present record in stock table
	 * Name updateStock
	 */
	@Override
	public void updateStock(StockModel stock) {
		Optional<StockModel> optional=stockRepository.findById(stock.getStockId()); 
		if(optional.isPresent()) {
			StockModel temp= optional.get();
			if(stock.getCategory()==null||stock.getCategory().isEmpty())
				stock.setCategory(temp.getCategory());
			if(stock.getDiscount()==null)
				stock.setDiscount(temp.getDiscount());
			if(stock.getMaterial()==null||stock.getMaterial().isEmpty())
				stock.setMaterial(temp.getMaterial());
			if(stock.getName()==null||stock.getName().isEmpty())
				stock.setName(temp.getName());
			if(stock.getPrice()==null)
				stock.setPrice(temp.getPrice());
			if(stock.getQuantity()==null)
				stock.setQuantity(temp.getQuantity());
			if(stock.getSize()==null)
				stock.setSize(temp.getSize());
			if(stock.getSubCategory()==null||stock.getSubCategory().isEmpty())
				stock.setSubCategory(temp.getSubCategory());
			stockRepository.save(stock);
		}
	}
	
	/**
	 * Delete method to Delete any record in stock table
	 * Name deleteStock
	 */
	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);
	}

	/**
	 * find method to Find record From stock table
	 * Name findStock
	 * @throws RecordNotFoundException 
	 */
	@Override
	public StockModel findStock(Long stockId) throws RecordNotFoundException {
		Optional<StockModel> optional=stockRepository.findById(stockId); 
		StockModel record=null;
		if(optional.isPresent()) { 
			record= optional.get();
		} else {
			throw new RecordNotFoundException("Record doesn't exist");
		}
		return record;
	}

	/**
	 * Find All method to save new record in stock table
	 * Name saveStock
	 */
	@Override
	public List<StockModel> findAllStock() {
		List<StockModel> StockRecords=stockRepository.findAll(); 
		return StockRecords;
	}
	/**
	 * find method to find stock by name.
	 * Name findStockByName
	 */
	public StockModel findStockByName(String stockName)throws RecordNotFoundException{
		System.out.println("stockName"+stockName);
     StockModel stock=stockRepository.findByName(stockName);	
     
	return stock;
	}
}
