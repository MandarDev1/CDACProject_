package com.mandardev.blog.repositories;

import java.util.Optional;




public interface UserRepo extends JpaRepository<User,Integer> {
	
	Optional<User>findByEmail(String email);

}
