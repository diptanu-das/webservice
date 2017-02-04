package org.nykaa.webservice.order.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nykaa.webservice.order.database.DatabaseClass;
import org.nykaa.webservice.order.model.Order;
import org.nykaa.webservice.order.model.OrderCollection;
import org.nykaa.webservice.order.service.OrderService;


@Path("/order")
public class OrderResource {
	
	OrderService orderService = new OrderService(); 

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public OrderCollection showCollection(){
		return this.orderService.getOrderCollection();
	}
	
	@POST
	@Path("/createOne")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public OrderCollection createOrder(Order order){
		this.orderService.addOrder(order);
		return this.orderService.getOrderCollection();
	}
	
	@POST
	@Path("/createMulti")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public OrderCollection createMultipleOrders(OrderCollection orderCollection){
		for(Order order : orderCollection.getOrderList())
			this.orderService.addOrder(order);
		return this.orderService.getOrderCollection();
	}
	
	@GET
	@Path("/testDb")
	@Produces(MediaType.TEXT_PLAIN)
	public String testDb(){
		String query = "select * from nykaalive1.sales_flat_order limit 10;";
		DatabaseClass db = new DatabaseClass();
		String[] fields = {"entity_id", "increment_id", "state", "status"};
		List<List<String>> r = db.execute(query, fields);
		String retStr = new String("");
		for(List<String> row : r){
			for(String cell : row){
				retStr += cell + "  ";
			}
			retStr += "<br>";
		}
		return retStr;
	}
	
}
