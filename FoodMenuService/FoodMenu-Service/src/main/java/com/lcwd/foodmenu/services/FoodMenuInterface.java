package com.lcwd.foodmenu.services;

import java.util.List;

import com.lcwd.foodmenu.entities.Food;

public interface FoodMenuInterface {
	
	Food createFood(Food food);
	
	List<Food> getAllFood();
	
	//List<Food> getFoodByUserId(String userId);
	
	List<Food> getFoodByHotelId(String hotelId);
	

}
