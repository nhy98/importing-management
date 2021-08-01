package com.group8.management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="ImportOrder")
@Table
public class ImportOrder {
	private int id;
	private SaleOrder order;
	private Product product;
	private Site site;
	private int quantity;
	private Transportation mean;
	private String status;
	
	public ImportOrder() {
		super();
	}

	public ImportOrder(SaleOrder order, Product product, Site site, int quantity, Transportation mean,
			String status) {
		super();
		this.order = order;
		this.product = product;
		this.site = site;
		this.quantity = quantity;
		this.mean = mean;
		this.status = status;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="orderID",nullable = false)
	public SaleOrder getOrder() {
		return order;
	}

	public void setOrder(SaleOrder order) {
		this.order = order;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productID",nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="siteID",nullable = false)
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mean",nullable = false)
	public Transportation getMean() {
		return mean;
	}

	public void setMean(Transportation mean) {
		this.mean = mean;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
