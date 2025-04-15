package com.springboot.Main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Main.Entity.User;
import com.springboot.Main.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService service;
	
	private Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/AddUser/user")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User us =this.service.addUser(user);
		return ResponseEntity.ok(us);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> us =this.service.getAllUser();
		return ResponseEntity.ok(us);
	}
	
	
	
	
	//int retryCount =1;
	
	@GetMapping("/getUserById/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker" ,fallbackMethod = "ratingHotelFallback")
	//@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	//@RateLimiter(name="userRateLimiter" ,fallbackMethod = "ratingHotelFallback" )
	public ResponseEntity<User> getUserById(@PathVariable int userId)
	{
		//logger.info("Retry count {} ",retryCount);
		//retryCount++;
	    User us  =this.service.getUserById(userId);
		return ResponseEntity.ok(us);
	}
	
	//creating fall back method for circuitBreaker
	public ResponseEntity<User> ratingHotelFallback(int userId, Exception ex) {
		logger.info("Fallback is executed beacuse service is down", ex.getMessage());
		
		  User user = new User();
		
		  user.setEmail("dummy@gmail.com"); 
		  user.setName("dummy");
		  user.setAbout("This user is created dummy beacuse some service is down");

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	 
	
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteById (@PathVariable int userId)
	{
		this.service.deleteUserById(userId);
	}
	
	@PutMapping("/updateUserById/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable int userId)
	{
		User us =this.service.updateUserById(user, userId);
		return ResponseEntity.ok(us);
	}
}
