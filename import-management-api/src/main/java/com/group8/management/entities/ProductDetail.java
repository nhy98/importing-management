package com.group8.management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="ProductDetail")
@Table
public class ProductDetail {
	private int id;
	private Product product;
	private SaleOrder order;
	private int quantiy;
	private int processQuantity;
	
	
	public ProductDetail() {
		super();
	}
	
	public ProductDetail(Product product, int quantiy) {
		super();
		this.product = product;
		this.quantiy = quantiy;
	}

	public ProductDetail( Product product, SaleOrder order, int quantiy,int processQuantity ) {
		super();
		this.product = product;
		this.order = order;
		this.quantiy = quantiy;
		this.processQuantity = processQuantity;
	}
	@Id
	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="productID")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="orderID",nullable = false)
	public SaleOrder getorder() {
		return order;
	}
	public void setorder(SaleOrder order) {
		this.order = order;
	}
	@Column(name="quantity")
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	@Column(name="processQuantity")
	public int getProcessQuantity() {
		return processQuantity;
	}

	public void setProcessQuantity(int processQuantity) {
		this.processQuantity = processQuantity;
	}
	
	
}
