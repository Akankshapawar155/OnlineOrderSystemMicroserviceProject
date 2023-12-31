package com.lcwd.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.services.impl.HotelServiceImpl;

@SpringBootTest(classes = { HotelServiceApplicationTests.class })
class HotelServiceApplicationTests {

	@Mock
	private HotelRepository repo;

	@InjectMocks
	private HotelServiceImpl service;

	@Test
	@Order(1)
	public void test_createHotel() {

		Hotel h1 = new Hotel("1", "Shabri", "Satana", "Good food");
		when(repo.save(h1)).thenReturn(h1);
		assertEquals("1", h1.getId());
	};

	@Test
	@Order(2)
	public void test_getAllHotels() {
		
		List<Hotel> list = new ArrayList<>();
		Hotel h1 = new Hotel("1", "Shabri", "Satana", "Good food");
		Hotel h2 = new Hotel("2", "Godavari", "Deola", "Good service");
		list.add(h1);
		list.add(h2);
		when(repo.findAll()).thenReturn(list);
		assertEquals(2, service.getAllHotels().size());
		
	};

	@Test
	@Order(3)
	public void test_getHotel() {
		Optional<Hotel> h1 = Optional.ofNullable(new Hotel("1", "Shabri", "Satana", "Good food"));
		
		when(repo.findById("1")).thenReturn(h1);
		assertEquals("1", h1.get().getId());
	};

}
