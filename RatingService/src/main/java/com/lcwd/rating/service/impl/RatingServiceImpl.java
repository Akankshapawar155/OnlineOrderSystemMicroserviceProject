package com.lcwd.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	private static final Logger log = LoggerFactory.getLogger(RatingServiceImpl.class);

	
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		log.info("Inside createUser method of class "+getClass().getName());

		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		log.info("Inside createUser method of class "+getClass().getName());
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		log.info("Inside createUser method of class "+getClass().getName());
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		log.info("Inside createUser method of class "+getClass().getName());

		return ratingRepo.findByHotelId(hotelId);
	}

}
