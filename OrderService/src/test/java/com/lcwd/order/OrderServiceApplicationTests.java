package com.lcwd.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.order.repositories.OrderRepository;
import com.lcwd.order.services.impl.OrderServiceImpl;


@SpringBootTest(classes = { OrderServiceApplicationTests.class })
class OrderServiceApplicationTests {
	
	@Mock
	OrderRepository repo;
	
	@InjectMocks
	OrderServiceImpl orderService;

	@Test
	@Order(1)
	public void test_createOrder() {
		
		com.lcwd.order.entities.Order order = new com.lcwd.order.entities.Order("1", "2", "3", "4");
		when(repo.save(order)).thenReturn(order);
		assertEquals("1",order.getOrderId() );
	}

	@Test
	@Order(2)
	public void test_getallOrder() {
		List<com.lcwd.order.entities.Order> list = new ArrayList<>();
		com.lcwd.order.entities.Order o1 = new com.lcwd.order.entities.Order("1", "2", "3", "4");
		com.lcwd.order.entities.Order o2 =	new com.lcwd.order.entities.Order("11", "22", "33", "44");
		list.add(o1);
		list.add(o2);
		when(repo.findAll()).thenReturn(list);
		assertEquals(2, orderService.getallOrder().size());
	}

	@Test
	@Order(3)
	public void test_getOrderByUser() {
		List<com.lcwd.order.entities.Order> list = new ArrayList<>();
		com.lcwd.order.entities.Order o1 = new com.lcwd.order.entities.Order("1", "2", "3", "4");
		com.lcwd.order.entities.Order o2 =	new com.lcwd.order.entities.Order("11", "22", "33", "44");
		list.add(o1);
		list.add(o2);
		when(repo.getOrderByUserId("2")).thenReturn(list);
		
		assertEquals("2", o1.getUserId());
	}

	@Test
	@Order(4)
	public void test_getOrderByHotelId() {
		List<com.lcwd.order.entities.Order> list = new ArrayList<>();
		com.lcwd.order.entities.Order o1 = new com.lcwd.order.entities.Order("1", "2", "3", "4");
		com.lcwd.order.entities.Order o2 =	new com.lcwd.order.entities.Order("11", "22", "33", "44");
		list.add(o1);
		list.add(o2);
		when(repo.getOrderByHotelId("3")).thenReturn(list);
		assertEquals("3", o1.getHotelId());
	}
}
