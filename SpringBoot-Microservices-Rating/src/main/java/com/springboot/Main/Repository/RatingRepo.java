package com.springboot.Main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Main.Entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer>
{
	//Custom Finder method
	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(int hotelId);
}
