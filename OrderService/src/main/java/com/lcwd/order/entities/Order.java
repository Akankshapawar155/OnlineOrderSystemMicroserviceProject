package com.lcwd.order.entities;

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
@Table(name = "orderservice")
public class Order {
	
	@Id
	private String orderId;
	private String userId;
	private String hotelId;
	private String foodId;
	
	
	public Order(String orderId, String userId, String hotelId, String foodId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.foodId = foodId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	
}
