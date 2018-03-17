package com.order.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.objects.Order;
import com.order.repository.OrderRepository;

@Transactional
@Component
public class OrderDaoImpl {
	@Autowired
	private OrderRepository orderRepo = null;
	
	public List<Order> getAllOrder() {
		return orderRepo.findAll();
	}
	
	public Order getOrderById(long orderId) {
		return orderRepo.findOne(orderId);
	}
	
	public void deleteOrder(long orderId) {
		orderRepo.delete(getOrderById(orderId));
	}
	
	public Order insertOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public Order updateOrder(Order order) {
		Order dbOrder = getOrderById(order.getOrderId());
		if(order.getProductId() != 0)
			dbOrder.setProductId(order.getProductId());
		if(order.getUserId() != 0)
			dbOrder.setUserId(order.getUserId());
		
		return orderRepo.save(dbOrder);
	}
}
