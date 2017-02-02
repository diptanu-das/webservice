package org.nykaa.webservice.order.service;

import java.util.ArrayList;
import java.util.List;

import org.nykaa.webservice.order.model.Order;

public class OrderService {
	
	private List<Order> list;
	
	public OrderService(){
		this.list = new ArrayList<>();
		Order ord1 = new Order("NW00013", "400023", 78.79, "COD", "2");
		Order ord2 = new Order("NW00014", "400024", 73.69, "Net Banking", "1");
		this.list.add(ord1);
		this.list.add(ord2);
	}
	
	public List<Order> getAllOrders(){
		return this.list;
	} 
	
	public void addOrder(Order order){
		this.list.add(order);
	}

}
