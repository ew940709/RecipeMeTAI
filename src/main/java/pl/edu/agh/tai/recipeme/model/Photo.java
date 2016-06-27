package pl.edu.agh.tai.recipeme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Id;
	
	@NotNull
	@ManyToOne
	private UserSecured author;
	
	@NotNull
	private Date date;
	
	@NotNull
	private byte[] content;
	
	@NotNull
	private String description;
	
	@NotNull
	private Long recipeId;

	public Photo(){
		
	}
	
	public Photo(UserSecured author, Date date, byte[] content, String description, Long recipeId) {
		super();
		this.author = author;
		this.date = date;
		this.content = content;
		this.description = description;
		this.recipeId = recipeId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
}
