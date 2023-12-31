package com.lcwd.user.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.user.service.UserService.entities.Order;
import com.lcwd.user.service.UserService.entities.Ratings;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.impl.UserServiceImpl;

@SpringBootTest(classes = { UserServiceApplicationTests.class })
class UserServiceApplicationTests {

	@Mock
	UserRepository userRepo;

	@InjectMocks
	UserServiceImpl userService;

	@Test
	@org.junit.jupiter.api.Order(1)
	void test_addUser() {

		User user = new User("1", "abc", "abc@gmail.com", "desc");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals("abc", userService.saveUser(user).getName());

	}

	@Test
	@org.junit.jupiter.api.Order(2)
	void test_getAllUsers() {
		List<User> users = new ArrayList<>();
		// List<Order> orders = Arrays.asList(users)
		// List<Ratings> ratings;
		users.add(new User("2", "xyz", "akanksha@gmail.com", "devloper"));
		users.add(new User("3", "jml", "jayraj@gmail.com", "devloper"));
		when(userRepo.findAll()).thenReturn(users);
		assertEquals(2, userService.getAllUser().size());

	}

	@Test

	@org.junit.jupiter.api.Order(3)

	void test_getUser() {

		Optional<User> user = Optional.ofNullable(new User("1", "abc", "abc@gmail.com", "desc"));
		when(userRepo.findById("1")).thenReturn(user);

		assertEquals("1", user.get().getUserId());

	}

}
