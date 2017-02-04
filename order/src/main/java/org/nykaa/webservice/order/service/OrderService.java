package org.nykaa.webservice.order.service;

import org.nykaa.webservice.order.model.Order;
import org.nykaa.webservice.order.model.OrderCollection;

public class OrderService {
	
	private OrderCollection orderCollection;
	
	public OrderService(){
		Order order = new Order(345678, "400023", 78.79, "COD", "2");
		this.orderCollection = new OrderCollection();
		this.orderCollection.addOrder(order);
	}

	public OrderCollection getOrderCollection() {
		return this.orderCollection;
	}

	public void setOrderCollection(OrderCollection orderCollection) {
		this.orderCollection = orderCollection;
	}
	
	public void addOrder(Order order){
		this.orderCollection.addOrder(order);
	}

}
