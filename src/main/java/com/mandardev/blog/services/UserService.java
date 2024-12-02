package com.mandardev.blog.services;

import java.util.List;




public interface UserService extends UserDetailsService {

	UserDTO createUser(@Valid UserDTO userDTO);

	UserDTO updateUser(UserDTO userDTO, Integer userId);

	UserDTO getUserById(Integer userId);

	List<UserDTO> getAllUsers();

	void deleteUser(Integer userId);

	// added
	UserDTO registerNewUser(UserDTO userDTO);

	UserDTO createUser1(User user);

}
