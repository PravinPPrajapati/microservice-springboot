package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.domain.objects.Order;
import com.domain.objects.Product;
import com.domain.objects.User;
import com.order.dao.OrderDaoImpl;

@RestController
@RequestMapping("/order")
public class OrderImpl {
	@Autowired
	private OrderDaoImpl orderDao = null;
	@Autowired
	private RestTemplate restTemplate = null;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Order> getAllOrders(){
		return orderDao.getAllOrder();
	}
	
	@GetMapping(value="/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Order getOrderById(@PathVariable("orderId") long orderId) {
		return orderDao.getOrderById(orderId);
	}
	
	@DeleteMapping(value="/delete/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteOrder(@PathVariable("orderId") long orderId) {
		orderDao.deleteOrder(orderId);
	}
	
	@PostMapping(value="/insert", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Order insertOrder(@RequestBody Order order) {
		return orderDao.insertOrder(order);
	}
	
	@PutMapping(value="/update/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Order updateOrder(@RequestBody Order order,
										   @PathVariable("orderId") long orderId) {
		order.setOrderId(orderId);
		return orderDao.insertOrder(order);
	}
	
	// http://localhost:9090/order/submitOrder?userId=5&productId=4
	@PostMapping(value="/submitOrder", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Order submitOrder(@Param("userId") long userId,
										   @Param("productId") long productId) {
		
		System.out.println("User Id= "+userId+", Product Id= "+productId);
		Order order = null;
		
	    Map<String, Object> uriVariables = new HashMap<>();
	    uriVariables.put("userId", userId);
	    uriVariables.put("productId", productId);

	    Product product = restTemplate.getForEntity("http://localhost:9092/product/{productId}", Product.class, uriVariables).getBody();
	    User user = restTemplate.getForEntity("http://localhost:9091/user/{userId}", User.class, uriVariables).getBody();
		
	    System.out.println("Pro name= "+product.getProductName()+", User= "+user.getUserName());
	    
	    if(product != null && user!= null)
	    	order = new Order(productId, userId);
	    
		return insertOrder(order);
	}
	
	
	
}
