package com.inventoryManagement.serviceInterface;

import java.util.List;

import com.inventoryManagement.exceptions.RecordNotFoundException;
import com.inventoryManagement.model.StockModel;

/**
 * @Description: Stock Service Interface to declare service method.
 * @InterfaceName: StockServiceInterface
 * @author shubhams11
 * @Date:06-05-2022
 */
public interface StockServiceInterface {
	public void saveStock(StockModel stock);
	public void updateStock(StockModel stock);
	public void deleteStock(Long stockId);
	public StockModel findStock(Long stockId)throws RecordNotFoundException;
	public StockModel findStockByName(String stockName)throws RecordNotFoundException;
	public List<StockModel> findAllStock();

}
