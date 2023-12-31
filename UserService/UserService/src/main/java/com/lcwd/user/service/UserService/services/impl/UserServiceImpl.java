package com.lcwd.user.service.UserService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.controllers.UserController;
import com.lcwd.user.service.UserService.entities.Order;
import com.lcwd.user.service.UserService.entities.Ratings;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.external.services.OrderService;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderService orderService;

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	@Override
	public User saveUser(User user) {

		log.info("Inside SaveUser method of class "+getClass().getName());

		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		log.info("Inside getAllUser method of class "+getClass().getName());

		return userRepo.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		
		log.info("Inside getUser method of class "+getClass().getName());

		// TODO Auto-generated method stub
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

		// fetch rating of user based on user

		/*
		 * ArrayList<Ratings> ratingsOfUser =
		 * restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, //
		 * ArrayList.class);
		 */

		ArrayList<Ratings> ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId,
				ArrayList.class);
		user.setRatings(ratingsOfUser);

		/*
		 * ArrayList<Order> orderByUser =
		 * restTemplate.getForObject("http://ORDER-SERVICE/orders/users/" + userId,
		 * ArrayList.class); user.setOrders(orderByUser);
		 */

		List<Order> list=orderService.orderByUserId(userId);
		user.setOrders(list);
		
		return user;
	}

	// http://localhost:8082/hotels/3013073d-22b9-4a38-aae9-30a0c6431585

}
