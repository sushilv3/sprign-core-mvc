package com.spring.guru.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Product {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	private Integer version;
	
	private String description;
	private BigDecimal price;
	private String imageUrl;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(Integer id, String description, BigDecimal price, String imageUrl) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public Integer getVersion() {
		return version;
	}



	public void setVersion(Integer version) {
		this.version = version;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl
				+ "]";
	}
	
	

}
