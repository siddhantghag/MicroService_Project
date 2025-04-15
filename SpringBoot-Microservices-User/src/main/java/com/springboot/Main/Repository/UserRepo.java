package com.springboot.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Main.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{

}
