package com.domain.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private long orderId;
	
	@Column(name="PRODUCT_ID")
	private long productId;
	
	@Column(name="USER_ID")
	private long userId;
	
	public Order() {
		
	}
	
	public Order(long productId, long userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}
	
	public Order(long orderId, long productId, long userId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
