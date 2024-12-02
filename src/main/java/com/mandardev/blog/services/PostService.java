package com.mandardev.blog.services;

import java.util.List;


public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get All Posts
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDto>getPostByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto>getPostsByUser(Integer userId);
	
	//search posts by keyword
	List<PostDto>searchPosts(String keyword);
	

}
