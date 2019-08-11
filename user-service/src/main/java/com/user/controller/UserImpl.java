package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.objects.User;
import com.user.dao.UserDaoImpl;

@RestController
@RequestMapping("/users")
public class UserImpl {
	@Autowired
	UserDaoImpl userDao = null;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getllUsers(){
		return userDao.getAllUsers();
	}
	
	@GetMapping(value="/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(@PathVariable("userId") long userId) {
		return userDao.getUserById(userId);
	}
	
	@DeleteMapping(value="/delete/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("userId") long userId) {
		userDao.deleteUser(userId);
	}
	
	@PostMapping(value="/insert", produces=MediaType.APPLICATION_JSON_VALUE)
	public User insertUser(@RequestBody User user) {
		return userDao.inserUser(user);
	}
	
	@PostMapping(value="/update/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user,
										 @PathVariable("userId") long userId) {
		user.setUserId(userId);
		return userDao.updateUser(user);
	}

}
