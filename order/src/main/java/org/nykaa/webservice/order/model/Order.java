package org.nykaa.webservice.order.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
public class Order {
	
	private String orderId;
	private String userId;
	
	private double totalCost;
	private String paymentMethod;
	
	private String shipMethodId;
	
	private Date createdAt;
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	@XmlElement
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Order(){}
	
	public Order(String oId, String uId, double tCost, String pMethod, String sMethodId){
		this.orderId = oId;
		this.userId = uId;
		this.totalCost = tCost;
		this.paymentMethod = pMethod;
		this.shipMethodId = sMethodId;	
		this.createdAt = new Date();
	}

	public String getOrderId() {
		return orderId;
	}

	@XmlAttribute
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	@XmlElement
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	@XmlElement
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	@XmlElement
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getShipMethodId() {
		return shipMethodId;
	}

	@XmlElement
	public void setShipMethodId(String shipMethodId) {
		this.shipMethodId = shipMethodId;
	}
	
}
