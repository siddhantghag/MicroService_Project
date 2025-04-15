package com.springboot.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Main.Entity.User;

@Service
public interface UserService 
{
	public User addUser(User user);
	public List<User> getAllUser();
	public User getUserById(int UserId);
	public void deleteUserById(int UserId);
	public User updateUserById(User user ,int UserId);
}
