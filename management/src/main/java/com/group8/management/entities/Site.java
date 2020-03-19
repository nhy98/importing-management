package com.group8.management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.criteria.Order;

@Entity(name="Sites")
@Table
public class Site {
	//private int id;
	private String siteID;
	private String siteName;
	private String address;
	private String phoneNumber;
	private List<SiteProduct> products;
	private List<Transportation> means;
	private List<ImportOrder> importOrders;
	
	public Site() {
		super();
	}
	
	public Site(String siteID, String siteName) {
		super();
		this.siteID = siteID;
		this.siteName = siteName;
	}

	public Site(String siteID, String siteName, List<SiteProduct> products, List<Transportation> means,String address, String phoneNumber,List<ImportOrder> importOrders) {
		super();
		this.siteID = siteID;
		this.siteName = siteName;
		this.products = products;
		this.means = means;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.importOrders =importOrders;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="phone")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	@Column(name="siteID")
	public String getSiteID() {
		return siteID;
	}
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	@Column(name="siteName")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@OneToMany(mappedBy = "site",fetch = FetchType.EAGER)
	public List<SiteProduct> getProducts() {
		return products;
	}
	public void setProducts(List<SiteProduct> products) {
		this.products = products;
	}
	@OneToMany(mappedBy = "site")
	public List<Transportation> getMeans() {
		return means;
	}
	public void setMeans(List<Transportation> means) {
		this.means = means;
	}
	@OneToMany(mappedBy = "site")
	public List<ImportOrder> getImportOrders() {
		return importOrders;
	}

	public void setImportOrders(List<ImportOrder> importOrders) {
		this.importOrders = importOrders;
	}
	
	
}
