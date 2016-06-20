package pl.edu.agh.tai.recipeme.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import pl.edu.agh.tai.hmm.RecipeForm;

@Entity
@Table(name="recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE )
	private Long Id;
	
	@NotNull
	private String title;
	
	@OneToMany
	private List<Ingredient> ingredientList;
	
	@OneToMany
	private List<Photo> photos;
	
	@NotNull
	@ManyToOne
	private User author;
	
	@NotNull
	private String description;
	
	@OneToMany
	private List<Comment> commentList;
	
	private Double averageRating;
	
	
	public Recipe(){
		
	}
	

	public Recipe(String title, User author, String description) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.averageRating = 0.0;
		this.commentList = new LinkedList<>();
		this.photos = new LinkedList<>();
		this.ingredientList = new LinkedList<>();
	}
	
	public Recipe(RecipeForm recipeForm){

		this.title = recipeForm.getTitle();
		this.author = recipeForm.getAuthor();
		this.description = recipeForm.getDescription();
		this.averageRating = 0.0;
		this.commentList = new LinkedList<>();
		this.photos = new LinkedList<>();
		this.ingredientList = new LinkedList<>();

	}

	public void fillIngredientList(List<Ingredient> ingredients) {
		
		for (Ingredient i: ingredients){
			ingredientList.add(i);
		}
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	
	public void addIngredient(Ingredient ingredient){
		this.ingredientList.add(ingredient);
	}
	
	public void addComment (Comment comment){
		this.commentList.add(comment);
	}
	
	public void addPhoto (Photo photo){
		this.photos.add(photo);
	}
	
	@Override
	public String toString(){
		return getId() + "-" + getTitle() + "-" + getDescription() + "-" + getAuthor().getName();
	}
}
