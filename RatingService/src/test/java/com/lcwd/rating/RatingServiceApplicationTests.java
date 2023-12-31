package com.lcwd.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.service.impl.RatingServiceImpl;

@SpringBootTest(classes = { RatingServiceApplicationTests.class })
class RatingServiceApplicationTests {

	@Mock
	RatingRepository ratingRepo;

	@InjectMocks
	RatingServiceImpl ratingService;

	@Test
	@Order(1)
	public void test_getAllRatings() {
		List<Rating> rt = new ArrayList<>();
		Rating r1 = new Rating("1", "2", "3", 9, "Good hotel");
		Rating r2 = new Rating("2", "3", "4", 10, "Good service");
		rt.add(r1);
		rt.add(r2);
		when(ratingRepo.findAll()).thenReturn(rt);
		assertEquals(2, ratingService.getRatings().size());
	}

	@Test
	@Order(2)
	public void test_getRatingByUserId() {

		List<Rating> rt = new ArrayList<>();
		Rating r1 = new Rating("1", "2", "3", 9, "Good hotel");
		rt.add(r1);
		when(ratingRepo.findByUserId("2")).thenReturn(rt);

		assertEquals("2", r1.getUserId());

	};

	@Test
	@Order(3)
	public void test_getRatingByHotelId() {

		List<Rating> rt = new ArrayList<>();
		Rating r1 = new Rating("1", "2", "3", 9, "Good hotel");
		rt.add(r1);
		when(ratingRepo.findByHotelId("3")).thenReturn(rt);
		assertEquals("3", r1.getHotelId());

	};

}
