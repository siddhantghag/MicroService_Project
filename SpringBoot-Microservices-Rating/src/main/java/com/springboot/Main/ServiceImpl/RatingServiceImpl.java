package com.springboot.Main.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Main.Entity.Rating;
import com.springboot.Main.Expection.ResourceNotFoundExpection;
import com.springboot.Main.Repository.RatingRepo;
import com.springboot.Main.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService
{
	@Autowired
	private RatingRepo ratingRepo;
	
	@Override
	public Rating addRatingInfo(Rating rating) {
		Rating rating1 =this.ratingRepo.save(rating);
		return rating1;
	}

	@Override
	public Rating getRatingById(int ratingId) {
		Rating rating1= this.ratingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundExpection("Resource not found "+ratingId));
		return rating1;
	}

	@Override
	public List<Rating> getAllRating() {
		List<Rating> rating =this.ratingRepo.findAll();
		return rating;
	}

	@Override
	public Rating UpdateRatingById(Rating rating, int ratingId) {
		rating.setRating(ratingId);
		Rating rating1= this.ratingRepo.save(rating);
		return rating1;
	}

	@Override
	public void DeleteRatingById(int ratingId) {
		this.ratingRepo.deleteById(ratingId);
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		
		return this.ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelid(int hotelId) {
		
		return this.ratingRepo.findByHotelId(hotelId);
	}

}
