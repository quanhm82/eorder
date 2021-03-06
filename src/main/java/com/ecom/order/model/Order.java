package com.ecom.order.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author quanhoang
 * Product Category as a resource
 */
@Entity
@Table(name = "TBL_ORDER")
public class Order {
	
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID orderId;
	
	@Column(name = "ORDER_DATE")
	private Timestamp orderDate;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "CUSTOMER_PHONE")
	private String customerPhone;
	
	@Column(name = "SHIPPING_ADDR")
	private String shippingAddress;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "DELIVERY_DATE")
	private Timestamp deliveryDate;
	
	@Column(name = "STATUS")
	private String status;

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getOrderId() {
		return orderId;
	}
	
}
