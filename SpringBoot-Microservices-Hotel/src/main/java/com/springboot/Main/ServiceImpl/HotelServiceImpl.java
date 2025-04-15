package com.springboot.Main.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Main.Entity.Hotel;
import com.springboot.Main.Expection.ResourcesNotFoundExpection;
import com.springboot.Main.Repository.HotelRepo;
import com.springboot.Main.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Hotel addHotel(Hotel hotel) 
	{
		Hotel hotels = this.hotelRepo.save(hotel);
		return hotels;
	}

	@Override
	public List<Hotel> getAllHotel() 
	{
		List<Hotel> hotels =this.hotelRepo.findAll();
		return  hotels;
	}

	@Override
	public Hotel getHotelById(int id) 
	{
		Hotel hotels = this.hotelRepo.findById(id).orElseThrow(()-> new ResourcesNotFoundExpection("plz check the Hotel id ...."));
		return hotels;
	}

	@Override
	public Hotel updateHotelDetailsById(Hotel hotel, int id) 
	{
		hotel.setId(id);
		Hotel hotels =this.hotelRepo.save(hotel);
		return hotels;
	}

	@Override
	public void deleteHotelById(int id) 
	{
		 this.hotelRepo.deleteById(id);
	}
}
