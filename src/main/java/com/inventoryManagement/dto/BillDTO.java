
package com.inventoryManagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class BillDTO {
	private Integer sNo[]; 
	private String productName[]; 
	private Float actualPrice[];
	private Float discount[];
	private Integer quantity[];
	private Float paybleAmount[];
	private String customerName;
	private Long customercontactNo;
	private String address;
	private String date;
	private Float totalGst;
	private Float totalDiscount;
	private Float totalPrice;
	private Float gst;
	
	
	public Integer getSNo(Integer index) {
		return sNo[index];
	}
	public String getProductName(Integer index) {
		return productName[index];
	}
	public Float getActualPrice(Integer index) {
		return actualPrice[index];
	}
	public Float getDiscount(Integer index) {
		return discount[index];
	}
	public Integer getQuantity(Integer index) {
		return quantity[index];
	}
	public Float getPaybleAmount(Integer index) {
		return paybleAmount[index];
	}

	

}
