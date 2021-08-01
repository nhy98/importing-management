package com.group8.management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="ADM_USER")
@Table
public class User {
	private int id;
	private String username;
	private String password;
	private String displayName;
	private String role;
	private int siteId;
	
	public User() {
		super();
	}
	
	

	public User(String username, String password, String displayName, String role, int siteId) {
		super();
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.role = role;
		this.siteId = siteId;
	}



	public User(int id, String username, String password, String displayName, String role, int siteId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.role = role;
		this.siteId = siteId;
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
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASS")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="DISPLAY_NAME")
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name="SITE_ID")
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}


	@Column(name="USER_ROLE")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}	
	