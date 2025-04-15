package com.springboot.Main.Controller;

import java.util.List;

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

import com.springboot.Main.Entity.Rating;
import com.springboot.Main.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController 
{
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addratinginfo")
	public ResponseEntity<Rating> addRatingInfo(@RequestBody Rating rating)
	{
		Rating rating1 =this.ratingService.addRatingInfo(rating);
		return new ResponseEntity<Rating>(rating1 ,HttpStatus.OK);
	}
	
	@GetMapping("/getratinginfobyid/{ratingId}")
	public ResponseEntity<Rating> getRatingInfoById(@PathVariable int ratingId)
	{
		Rating rating1 =this.ratingService.getRatingById(ratingId);
		return new ResponseEntity<Rating>(rating1 ,HttpStatus.OK);
	}
	
	@GetMapping("/getallrating")
	public ResponseEntity<List<Rating>> getAllRating()
	{
		List<Rating> rating1=this.ratingService.getAllRating();
		return new ResponseEntity<List<Rating>>(rating1 ,HttpStatus.OK);
	}
	
	@PutMapping("/updateratingbyid/{ratingId}")
	public ResponseEntity<Rating> updateRatingById(@RequestBody Rating rating , @PathVariable int ratingId)
	{
		Rating rating1 =this.ratingService.UpdateRatingById(rating, ratingId);
		return new ResponseEntity<Rating>(rating1 ,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteratingbyid/{ratingId}")
	public void deleteReatingById(@PathVariable int ratingId)
	{
		this.ratingService.DeleteRatingById(ratingId);
	}
	
	@GetMapping("/getratingbyuserid/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int userId)
	{
		List<Rating> rating1 = this.ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(rating1 ,HttpStatus.OK);
	}
	
	@GetMapping("/getratingbyhotelid/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable int hotelId)
	{
		List<Rating> rating1 = this.ratingService.getRatingByHotelid(hotelId);
		return new ResponseEntity<List<Rating>>(rating1 ,HttpStatus.OK);
	}
}

