package com.group8.management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="Product")
@Table
public class Product {
	//private int id;
	private String productID;
	private String name;
	private String unit;
	private List<ProductDetail> productDetails;
	private List<SiteProduct> products;
	
	public Product() {
		super();
	}
	
	public Product(String productID, String name, String unit) {
		super();
		this.productID = productID;
		this.name = name;
		this.unit = unit;
	}

	public Product( String productID, String name, String unit, List<SiteProduct> products, List<ProductDetail> productDetails) {
		super();
		this.productID = productID;
		this.name = name;
		this.unit = unit;
		this.products = products;
		this.productDetails = productDetails;
	}
//	@Id
//	@TableGenerator(name = "gen_id", table = "HIBERNATE_GEN_ID", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_id")
//	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
	@Id
	@Column(name="productID")
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@OneToMany(mappedBy = "product")
	public List<SiteProduct> getProducts() {
		return products;
	}
	public void setProducts(List<SiteProduct> products) {
		this.products = products;
	}
    @OneToMany(mappedBy = "product")
	public List<ProductDetail> getProductDetail() {
		return productDetails;
	}
	public void setProductDetail(List<ProductDetail> productDetail) {
		this.productDetails = productDetail;
	}
	
	
}
