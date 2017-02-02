package org.nykaa.webservice.order.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nykaa.webservice.order.model.Order;
import org.nykaa.webservice.order.service.OrderService;


@Path("/order")
public class OrderResource {
	
	OrderService orderService = new OrderService(); 

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> showAllOrders(){
		return this.orderService.getAllOrders();
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<Order> createOrder(Order order){
		this.orderService.addOrder(order);
		return this.orderService.getAllOrders();
	}
	
}
