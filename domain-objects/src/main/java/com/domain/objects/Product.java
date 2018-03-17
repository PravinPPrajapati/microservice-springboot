package com.domain.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_DESC")
	private String productDesc;
	
	public Product() {
		
	}
	
	public Product(long productId, String productName, String productDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
	}
	
	public Product(String productName, String productDesc) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	

}
