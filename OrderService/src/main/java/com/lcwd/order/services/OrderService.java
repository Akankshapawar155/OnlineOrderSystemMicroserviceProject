package com.lcwd.order.services;

import java.util.List;

import com.lcwd.order.entities.Order;

public interface OrderService {
	
	Order createOrder(Order order);
	
	List<Order> getallOrder();
	
	List<Order> getOrderByUser(String userId);
	
	List<Order> getOrderByHotelId(String hotelId);

}
