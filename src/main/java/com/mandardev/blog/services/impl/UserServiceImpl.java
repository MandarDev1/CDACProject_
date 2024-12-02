package com.mandardev.blog.services.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mandardev.blog.payloads.UserDTO;
import com.mandardev.blog.repositories.UserRepo;




@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setDescription(userDTO.getDescription());

		User updateUser = this.userRepo.save(user);
		UserDTO UserDTO1 = this.userToDto(updateUser);
		return UserDTO1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> UserDTOs = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return UserDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = this.modelMapper.map(userDTO, User.class);
//		user.setId(UserDTO.getId());
//		user.setName(UserDTO.getName());
//		user.setEmail(UserDTO.getEmail());
//		user.setAbout(UserDTO.getName());
//		user.setPassword(UserDTO.getPassword());
		return user;
	}

	public UserDTO userToDto(User user) {
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
//			UserDTO.setId(user.getId());
//			UserDTO.setName(user.getName());
//			UserDTO.setEmail(user.getEmail());
//			UserDTO.setPassword(user.getPassword());
//			UserDTO.setAbout(user.getAbout());
		return userDTO;
	}

	@Override
	public UserDTO registerNewUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO createUser1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
