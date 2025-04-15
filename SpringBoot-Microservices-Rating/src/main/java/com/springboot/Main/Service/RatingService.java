package com.springboot.Main.Service;

import java.util.List;

import com.springboot.Main.Entity.Rating;

public interface RatingService 
{
	public Rating addRatingInfo(Rating rating);
	public Rating getRatingById(int ratingId);
	public List<Rating> getAllRating();
	public Rating UpdateRatingById(Rating rating , int ratingId);
	public void DeleteRatingById(int ratingId);
	
	//get all rating by userId.( Means how much rating for user ).
	public List<Rating> getRatingByUserId(int userId);
	
	//get all rating by hotelId ( Means how much rating for hotel).
	public List<Rating> getRatingByHotelid(int hotelId);
}
