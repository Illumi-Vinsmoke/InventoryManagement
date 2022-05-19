package com.inventoryManagement.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @Description Model class for orders and records.
 * @className OrderModel 
 * @author shubhams11
 * @date 11-05-2022
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private String customerName;
	private Long customercontactNo;
	private String address;
	private Date date;
	private Float totalGst;
	private Float totalDiscount;
	private Float totalbill;
	@OneToMany(mappedBy="salesId",cascade = CascadeType.ALL)
	Set<SalesModel> sale=new HashSet<SalesModel>();
}
