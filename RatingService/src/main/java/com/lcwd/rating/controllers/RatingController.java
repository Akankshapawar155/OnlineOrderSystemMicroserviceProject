package com.lcwd.rating.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	private static final Logger log = LoggerFactory.getLogger(RatingController.class);


	@Autowired
	private RatingService ratingService;

	// create
	@PostMapping
	private ResponseEntity<Rating> create(@RequestBody Rating rating) {
		log.info("Inside  method"+getClass().getMethods().toString()+" of class "+getClass().getName().toString());

		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

	}
	
	//getAll
	@GetMapping
	private ResponseEntity<List<Rating>> getRatings(){
		log.info("Inside  method"+getClass().getMethods().toString()+" of class "+getClass().getName().toString());

		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
	}
	
	@GetMapping("/users/{userId}")
	private ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		log.info("Inside  method"+getClass().getMethods().toString()+" of class "+getClass().getName().toString());

		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	private ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		log.info("Inside  method"+getClass().getMethods().toString()+" of class "+getClass().getName().toString());

		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
	
}
