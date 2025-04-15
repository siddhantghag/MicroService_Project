package com.springboot.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Main.Entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer>
{

}
