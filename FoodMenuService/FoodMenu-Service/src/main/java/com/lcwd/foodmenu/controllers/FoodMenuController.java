package com.lcwd.foodmenu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.foodmenu.entities.Food;
import com.lcwd.foodmenu.services.FoodMenuInterface;

@RestController
@RequestMapping("/foods")
public class FoodMenuController {
	
	@Autowired
	FoodMenuInterface foodMenuService;
	
	@PostMapping
	private ResponseEntity<Food> createFood(@RequestBody Food food){
		Food newFood = foodMenuService.createFood(food);
		return new ResponseEntity<Food>(newFood,HttpStatus.CREATED);		
	}
	
	
	@GetMapping
	private ResponseEntity<List<Food>> getAllFoodItems(){
		List<Food> getall = foodMenuService.getAllFood();
		return new ResponseEntity<List<Food>>(getall,HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/users/{userId}") private ResponseEntity<List<Food>>
	 * getFoodByUserId(String userId){ List<Food> foodByUser =
	 * foodMenuService.getFoodByUserId(userId); return new
	 * ResponseEntity<List<Food>>(foodByUser,HttpStatus.OK);
	 * 
	 * }
	 */
	
	@GetMapping("/hotels/{hotelId}")
	private ResponseEntity<List<Food>> getFoodByHotelId(String hotelId){
		List<Food> foodByHotel = foodMenuService.getFoodByHotelId(hotelId);
		return new ResponseEntity<List<Food>>(foodByHotel,HttpStatus.OK);
		
	}

}
