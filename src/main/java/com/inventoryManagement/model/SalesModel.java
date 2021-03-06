package com.inventoryManagement.model;

	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	public class SalesModel {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long salesId;
		private Integer sNo;
		private String productName;
		private Float actualPrice;
		private Float discount;
		private Integer quantity;
		private Float paybleAmount;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="Order_id", nullable=false)
		private OrderModel order=new OrderModel();
				
	}
