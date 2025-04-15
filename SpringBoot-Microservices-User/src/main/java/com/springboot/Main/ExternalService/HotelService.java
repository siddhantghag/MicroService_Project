package com.springboot.Main.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.Main.Entity.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService 
{
	@GetMapping("/hotels/gethotelbyid/{id}")
	public Hotel getHotel(@PathVariable int id);
}
