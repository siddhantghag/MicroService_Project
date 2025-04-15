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

import com.springboot.Main.Entity.Hotel;
import com.springboot.Main.Service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController 
{
	@Autowired
	private HotelService hotelService; 
	
	@PostMapping("/savehotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
	{
		Hotel hotels =this.hotelService.addHotel(hotel);
		return   new ResponseEntity<Hotel>(hotels, HttpStatus.OK);
	}
	
	@GetMapping("/getallhotel")
	public  ResponseEntity<List<Hotel>> getallHotel()
	{
		List<Hotel> hotels = this.hotelService.getAllHotel();
		return new ResponseEntity<List<Hotel>>(hotels ,HttpStatus.OK);
	}
	
	@GetMapping("/gethotelbyid/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int id)
	{
		Hotel hotel = this.hotelService.getHotelById(id);
		return new ResponseEntity<Hotel>(hotel ,HttpStatus.OK);
	}
	
	@PutMapping("/updatehotelbyid/{id}")
	public ResponseEntity<Hotel> updateHotelById(@RequestBody Hotel hotel ,@PathVariable int id)
	{
		Hotel hotels = this.hotelService.updateHotelDetailsById(hotel, id);
		return  new ResponseEntity<Hotel>(hotels,HttpStatus.OK);
	}
	 
	@DeleteMapping("/deletebyid/{id}")
	public void deleteHotelById(@PathVariable int id)
	{
		 this.hotelService.deleteHotelById(id);
	}
}
