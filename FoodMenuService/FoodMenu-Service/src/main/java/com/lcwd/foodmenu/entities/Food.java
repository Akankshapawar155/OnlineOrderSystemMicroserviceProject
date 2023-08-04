package com.lcwd.foodmenu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "foodmenu")
public class Food {
	
	@Id
	private String foodId;
	private String foodName;
	private String foodPrice;
	private String hotelId;
	//private String userId;
	
	
	
	public String getFoodId() {
		return foodId;
	}
	public Food(String foodId, String foodName, String foodPrice, String hotelId) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.hotelId = hotelId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	/*
	 * public String getUserId() { return userId; } public void setUserId(String
	 * userId) { this.userId = userId; }
	 */
	
	
	

}
