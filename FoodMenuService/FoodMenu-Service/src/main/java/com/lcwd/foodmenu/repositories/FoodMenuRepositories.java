package com.lcwd.foodmenu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lcwd.foodmenu.entities.Food;



public interface FoodMenuRepositories extends JpaRepository<Food, String>{
	
	//List<Food> findByUserId(String userId);
	List<Food> findByHotelId(String hotelId);

}
