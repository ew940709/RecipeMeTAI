package com.dreamchain.skeleton.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Id;
	
	@NotNull
	@ManyToOne
	private UserSecured author;
	
	@NotNull
	private String content;
	
	private int rating;
	
	@NotNull
	private Date date;

	
	
	public Comment(UserSecured author, String content,  Date date) {
		super();
		this.author = author;
		this.content = content;
		this.rating = 0;
		this.date = date;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public UserSecured getAuthor() {
		return author;
	}

	public void setAuthor(UserSecured author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
