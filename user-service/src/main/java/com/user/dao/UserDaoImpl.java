package com.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.objects.User;
import com.user.repository.UserRepository;

@Transactional
@Component
public class UserDaoImpl {

	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUserById(long userId) {
		return userRepo.findOne(userId);
	}
	
	public void deleteUser(long userId) {
		userRepo.delete(getUserById(userId));
	}
	
	public User inserUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		User dbUser = getUserById(user.getUserId());
		if(user.getUserName() != null)
			dbUser.setUserName(user.getUserName());
		if(user.getEmail() != null)
			dbUser.setEmail(user.getEmail());
		if(user.getPassword() != null)
			dbUser.setPassword(user.getPassword());
		
		return userRepo.save(dbUser);
	}
}
