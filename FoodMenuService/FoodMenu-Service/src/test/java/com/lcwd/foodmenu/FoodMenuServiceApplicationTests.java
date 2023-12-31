package com.lcwd.foodmenu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.foodmenu.entities.Food;
import com.lcwd.foodmenu.repositories.FoodMenuRepositories;
import com.lcwd.foodmenu.services.impl.FoodMenuServiceImpl;

@SpringBootTest(classes = { FoodMenuServiceApplicationTests.class })
class FoodMenuServiceApplicationTests {

	@Mock
	FoodMenuRepositories repo;

	@InjectMocks
	FoodMenuServiceImpl service;

	@Test
	@Order(1)
	public void test_createFood() {
		
		Food f1 = new Food("1", "Dal Khichadi", "120", "101");
		when(repo.save(f1)).thenReturn(f1);
		assertEquals("1",f1.getFoodId());
	};

	@Test
	@Order(2)
	public void test_getAllFood() {
		
		List<Food> list = new ArrayList<>();
		Food f1 = new Food("1", "Dal Khichadi", "120", "101");
		Food f2 = new Food("2", "Shev Bhaji", "100", "102");
		list.add(f1);
		list.add(f2);
		when(repo.findAll()).thenReturn(list);
		assertEquals(2, service.getAllFood().size());
		
	};

	@Test
	@Order(3)
	public void test_getFoodByHotelId() {

		List<Food> list = new ArrayList<>();
		Food f1 = new Food("1", "Dal Khichadi", "120", "101");
		Food f2 = new Food("2", "Shev Bhaji", "100", "102");
		list.add(f1);
		list.add(f2);
		when(repo.findByHotelId("101")).thenReturn(list);
		assertEquals("101",f1.getHotelId());
		
	};
}
