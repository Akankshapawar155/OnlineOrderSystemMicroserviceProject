package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices {
	
	@Autowired
	HotelRepository hotelRepo;

	public Hotel createHotel(Hotel hotel) {
		
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		Hotel hotel1 = hotelRepo.save(hotel);
		return hotel1;
	}

	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelRepo.findAll();
		return hotels;
	}

	public Hotel getHotel(String id) {
		Hotel hotel2 = hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found ."));
		return hotel2;
	}

}
