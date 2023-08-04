package com.lcwd.order.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

	List<Order> getOrderByUserId(String userId);
	List<Order> getOrderByHotelId(String hotelId);
}
