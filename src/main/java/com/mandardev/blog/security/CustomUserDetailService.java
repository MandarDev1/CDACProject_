package com.mandardev.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mandardev.blog.repositories.UserRepo;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username == null || username.isEmpty()) {
	        throw new UsernameNotFoundException("Username is empty or null");
	    }
		
		//loading user from database by username
//		User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","email : "+username,0));
		User user=this.userRepo.findByEmail(username).orElseThrow(()->new RuntimeException("User Not Found"));

		return user;
	}

}
