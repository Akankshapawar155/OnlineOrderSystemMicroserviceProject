package com.lcwd.order.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.order.entities.Order;
import com.lcwd.order.repositories.OrderRepository;
import com.lcwd.order.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepo;

	@Override
	public Order createOrder(Order order) {
		String id = UUID.randomUUID().toString();
		order.setOrderId(id);
		Order o1 = orderRepo.save(order);
		return o1;
	}

	@Override
	public List<Order> getallOrder() {
		List<Order> list = orderRepo.findAll();
		return list;
	}

	@Override
	public List<Order> getOrderByUser(String userId) {
   
		return orderRepo.getOrderByUserId(userId);
	}

	@Override
	public List<Order> getOrderByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return orderRepo.getOrderByHotelId(hotelId);
	}

}
