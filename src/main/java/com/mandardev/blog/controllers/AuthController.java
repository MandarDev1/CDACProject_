package com.mandardev.blog.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandardev.blog.payloads.JwtAuthRequest;
import com.mandardev.blog.payloads.JwtAuthResponse;
import com.mandardev.blog.repositories.UserRepo;
import com.mandardev.blog.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody JwtAuthRequest request) {

		User user = userService.loadUserByUsername(request.getEmail());
		
		this.doAuthenticate(userDetails.getUsername(), request.getPassword());
		
		String token = this.helper.generateToken(userDetails);

		// Retrieve the user entity and map it to UserDTO
		User user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new ApiException("User not found"));
		UserDTO userDTO = mapper.map(user, UserDTO.class);

		JwtAuthResponse response = JwtAuthResponse.builder().token(token).userDTO(userDTO).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

	@PostMapping("/create-user")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.createUser(userDTO);
	}

}
