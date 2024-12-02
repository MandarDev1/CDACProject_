package com.mandardev.blog.entities;




import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postid;
	
	@Column(name="post_title",length = 100,nullable = false)
	private String title;
	
	@Column(length=1000)
	private String content;
	
	private String imageName;
	
	//private LocalDate addedDate; // Use LocalDate for dates chatgpt
	private LocalDateTime addedDate;

	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;//to know in which category added
	
	@ManyToOne
	private User user;//to know in which user added
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private Set<Comment>comments=new HashSet<>(); //for comment api
	

}