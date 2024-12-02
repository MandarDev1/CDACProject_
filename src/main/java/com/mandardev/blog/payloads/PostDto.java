package com.mandardev.blog.payloads;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostDto {
	
	private Integer postid;

	private String title;

	private String content;

	private String imageName;

	private LocalDate addedDate;

	private CategoryDto category;

	private UserDTO user;

	private Set<CommentDto> comments = new HashSet<>();


}
