package com.springboot.Main.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.Main.Entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService 
{
	
	@PostMapping("/addratinginfo")
	public Rating createRating(Rating rating);
	
	
	@PutMapping("/updateratingbyid/{ratingId}")
	public Rating updateRating(@PathVariable int ratingId , Rating rating );
	
	
	@DeleteMapping("/deleteratingbyid/{ratingId}")
	public void deleteRating(@PathVariable int ratingId , Rating rating );
	
}


