package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelServices {

	// create
	Hotel createHotel(Hotel hotel);
	
	// getAll
	List<Hotel> getAllHotels();
	
    //getone
	Hotel getHotel(String id);
	
}
