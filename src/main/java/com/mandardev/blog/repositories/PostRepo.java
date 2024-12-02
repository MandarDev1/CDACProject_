package com.mandardev.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	List<Post> findByTitleContaining(String title); // searching

}
