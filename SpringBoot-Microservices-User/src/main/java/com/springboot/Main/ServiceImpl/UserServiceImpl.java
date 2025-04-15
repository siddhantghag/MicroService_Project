package com.springboot.Main.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.Main.Entity.Hotel;
import com.springboot.Main.Entity.Rating;
import com.springboot.Main.Entity.User;
import com.springboot.Main.Expection.ResourceNotFoundExpection;
import com.springboot.Main.ExternalService.HotelService;
import com.springboot.Main.Repository.UserRepo;
import com.springboot.Main.Service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User addUser(User user) {
		User us= this.userRepo.save(user);
		return us;
	}

	@Override
	public List<User> getAllUser() {
		List<User> us = this.userRepo.findAll();
		for(User u : us)
		{
			 //Fetching rating of the above user from RatingService. 
			 ArrayList ratingforUser =restTemplate.getForObject("http://RATING-SERVICE/ratings/getratingbyuserid/"+u.getId(),ArrayList.class); 
			 logger.info("{} ",ratingforUser);
			 u.setRatings(ratingforUser);
		}
		return us;
	}
		  
	@Override
	public User getUserById(int UserId) 
	{
		//get all User by UserID
		User us =this.userRepo.findById(UserId).orElseThrow(()-> new ResourceNotFoundExpection("User Id given not Found..."+ UserId));
		
	   //Fetching rating of the above user from RatingService. 
	   //Use this url - localhost:9092/getratingbyuserid/1
		Rating [] RatingForUSerID =restTemplate.getForObject("http://RATING-SERVICE/ratings/getratingbyuserid/"+us.getId(), Rating[].class);
		logger.info("{} ",RatingForUSerID);
		
		List<Rating> ratings = Arrays.stream(RatingForUSerID).toList();
		
		List<Rating> ratingList = ratings.stream().map(Rating ->{
			
			//step 1 = API call the hotel service to get hotel
			
			//Use the Rest Templete HTTP client we call the other service.
			ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/gethotelbyid/"+Rating.getHotelId(), Hotel.class);
			Hotel hotel =hotelEntity.getBody();
			logger.info("Responces status code{} :",hotelEntity.getStatusCode());
			
			
			//But we can use Feign client so we can call the other Service.
			//Hotel hotel =hotelService.getHotel(Rating.getHotelId());
			
			
			// Step 2 = set the hotel to rating
			Rating.setHotel(hotel);
			
			// step 3 = return rating
			return Rating;
			
		}).collect(Collectors.toList());
		
		us .setRatings(ratingList);

		return us;
	}

	@Override
	public void deleteUserById(int UserId) {
		this.userRepo.deleteById(UserId);
	} 

	@Override
	public User updateUserById(User user, int UserId) {

		user.setId(UserId);
		User result=this.userRepo.save(user);
		return result;
	}

	
}
