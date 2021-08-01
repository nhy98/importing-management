package com.group8.management.entities;
import java.util.List;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="SaleOrder")
@Table
public class SaleOrder {
	//private int id;
	private String orderId;
	private String status;
	private Date desiredDate;
	private List<ProductDetail> products;
	private List<ImportOrder> importOrders;
	
	
	public SaleOrder() {
		super();
	}
	public SaleOrder(String orderId, String status, Date desiredDate,List<ProductDetail> products,List<ImportOrder> importOrders) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.desiredDate = desiredDate;
		this.products = products;
		this.importOrders = importOrders;
	}
//	@Id
//	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
//	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	@Id
	@Column(name="orderID",unique = true)
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="desiredDate")
	public Date getDesiredDate() {
		return desiredDate;
	}
	public void setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
	}
	@OneToMany(mappedBy = "order")
	public List<ProductDetail> getproducts() {
		return products;
	}
	public void setproducts(List<ProductDetail> products) {
		this.products = products;
	}
	@OneToMany(mappedBy = "order")
	public List<ImportOrder> getImportOrders() {
		return importOrders;
	}
	public void setImportOrders(List<ImportOrder> importOrders) {
		this.importOrders = importOrders;
	}
	
	
}
