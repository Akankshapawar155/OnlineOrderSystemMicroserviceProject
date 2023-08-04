package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entities.Rating;

public interface RatingService {
	
//create
Rating createRating(Rating rating);
	
//get all ratings
List<Rating> getRatings();

//get all by user Id
List<Rating> getRatingByUserId(String userId);
	
//get all by hotel
List<Rating> getRatingByHotelId(String hotelId);
}
