package com.inventoryManagement.model;

/**
 * @description stock model to keep details of stock present in inventory.
 * @ClassName StockModel 
 * @author shubhams11
 * @06-05-2022
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;
	@Column(unique = true)
	private String name;
	private String material;
	private String category;
	private String subCategory;
	private Float price;
	private Float discount;
	private Integer size;
	private Integer quantity;

}
