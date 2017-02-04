package org.nykaa.webservice.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orderCollection")
public class OrderCollection {
	
	private List<Order> orderList;
	
	public OrderCollection(){
		this.orderList = new ArrayList<>();
	}
	
	public OrderCollection(List<Order> orderList){
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	@XmlElement
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void addOrder(Order order){
		this.orderList.add(order);
	}
}
