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

@Entity(name="Transportation")
@Table
public class Transportation {
//	private int id;
	private String meansID;
	private Site site;
	private String name;
	private int deliveryDays;
	private String other;
	private List<ImportOrder> importOrders;
	
	public Transportation() {
		super();
	}
	
	public Transportation(String meansID, Site site, String name, int deliveryDays, String other) {
		super();
		this.meansID = meansID;
		this.site = site;
		this.name = name;
		this.deliveryDays = deliveryDays;
		this.other = other;
	}

	public Transportation( String meansID, String name, int deliveryDays, String other,Site site,List<ImportOrder> importOrders) {
		super();
		this.meansID = meansID;
		this.name = name;
		this.deliveryDays = deliveryDays;
		this.other = other;
		this.site = site;
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
	@Column(name="meansID")
	public String getMeansID() {
		return meansID;
	}
	
	public void setMeansID(String meansID) {
		this.meansID = meansID;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="deliveryDays")
	public int getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	@Column(name="other")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="siteID",nullable = false)
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	@OneToMany(mappedBy = "mean",fetch = FetchType.EAGER)
	public List<ImportOrder> getImportOrders() {
		return importOrders;
	}
	public void setImportOrders(List<ImportOrder> importOrders) {
		this.importOrders = importOrders;
	}
	
}
