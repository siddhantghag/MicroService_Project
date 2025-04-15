package com.springboot.Main.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.Main.Entity.Hotel;

public interface HotelService 
{
	public Hotel addHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getHotelById(int id);
	public Hotel updateHotelDetailsById(Hotel hotel , int id);
	public void deleteHotelById(int id);
}
