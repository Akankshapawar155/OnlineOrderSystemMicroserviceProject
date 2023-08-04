package com.lcwd.foodmenu.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.foodmenu.entities.Food;
import com.lcwd.foodmenu.repositories.FoodMenuRepositories;
import com.lcwd.foodmenu.services.FoodMenuInterface;

@Service
public class FoodMenuServiceImpl implements FoodMenuInterface{
	
	@Autowired
	FoodMenuRepositories foodRepo;

	@Override
	public Food createFood(Food food) {
		String foodId = UUID.randomUUID().toString();
		food.setFoodId(foodId);
		Food f1 = foodRepo.save(food);
		
		return f1;
	}

	@Override
	public List<Food> getAllFood() {
		List<Food> list = foodRepo.findAll();
		return list;
	}

	/*
	 * @Override public List<Food> getFoodByUserId(String userId) { List<Food>
	 * foodByUserId = foodRepo.findByUserId(userId); return foodByUserId; }
	 */

	@Override
	public List<Food> getFoodByHotelId(String hotelId) {
		List<Food> foodByHotelId = foodRepo.findByHotelId(hotelId);
		return foodByHotelId;
	}

}
