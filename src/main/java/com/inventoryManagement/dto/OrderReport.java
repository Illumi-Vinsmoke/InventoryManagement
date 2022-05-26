package com.inventoryManagement.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @description Class to get value from database and set into jasper Report.
 * @ClassName OrderReport
 * @author shubhams11
 */


@Getter @Setter 
public class OrderReport {

	private String customerName;
	private String address;
	private String customercontactNo;
	private String date ;
	private Integer Sno;
	private String productName;
	private String productDiscount;
	private String productQuantity;
	private String markedPrice;
	private String payblePrice;
	private String productTotal;
	private String totalDiscount;
	private String TotalPrice;
	private String TotalGst;
	private String gst;
	
}
