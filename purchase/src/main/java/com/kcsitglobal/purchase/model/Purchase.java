package com.kcsitglobal.purchase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE")

public class Purchase {
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="QUANTITY")
	private double quantity;
	
	@Column(name="PRICE")
	private double price;
	
	private Long custId;

	public Purchase() {
		super();
	}

	public Purchase(Long id, double quantity, double price, Long custId) {
		
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.custId = custId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

}