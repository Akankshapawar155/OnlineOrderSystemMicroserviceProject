package com.lcwd.user.service.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.UserService.entities.Order;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderService {
	
@GetMapping("/orders/users/{userId}")	
List<Order> orderByUserId(@PathVariable("userId") String orderId);

}
