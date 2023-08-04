package com.lcwd.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.order.entities.Order;
import com.lcwd.order.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping
	ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order order1 = orderService.createOrder(order);

		return new ResponseEntity<Order>(order1, HttpStatus.CREATED);

	}

	@GetMapping
	ResponseEntity<List<Order>> getAll() {
		List<Order> list = orderService.getallOrder();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);

	}

	@GetMapping("/users/{userId}")
	ResponseEntity<List<Order>> getByUserId(@PathVariable String userId) {
		List<Order> l1 = orderService.getOrderByUser(userId);
		return new ResponseEntity<List<Order>>(l1, HttpStatus.OK);

	}

	@GetMapping("/hotels/{hotelId}")
	ResponseEntity<List<Order>> getByHotelId(@PathVariable String hotelId) {
		List<Order> l2 = orderService.getOrderByHotelId(hotelId);
		return new ResponseEntity<List<Order>>(l2, HttpStatus.OK);

	}

}
