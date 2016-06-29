package pl.edu.agh.tai.recipeme.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import pl.edu.agh.tai.recipeme.util.RecipeForm;

@Entity
@Table(name="recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long Id;
	
	@NotNull
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Ingredient> ingredientList;
	
	@NotNull
	@ManyToOne
	private User author;
	
	@NotNull
	private String description;
	
	private Double averageRating;
	
	private Integer votesCount = 0;
	
	
	public Recipe(){
		
	}
	

	public Recipe(String title, User author, String description) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.averageRating = 0.0;
		this.ingredientList = new LinkedList<>();
		this.votesCount = 0;
	}
	
	public Recipe(RecipeForm recipeForm){

		this.title = recipeForm.getTitle();
		this.author = recipeForm.getAuthor();
		this.description = recipeForm.getDescription();
		this.averageRating = 0.0;
		this.ingredientList = new LinkedList<>();
		this.votesCount = recipeForm.getVotesCount();

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

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	
	public void addIngredient(Ingredient ingredient){
		this.ingredientList.add(ingredient);
	}

	public Integer getVotesCount() {
		return votesCount;
	}

	public void setVotesCount(Integer votesCount) {
		this.votesCount = votesCount;
	}

	@Override
	public String toString(){
		return getId() + "-" + getTitle() + "-" + getDescription() + "-" + getAuthor().getName();
	}
	
	public void incrementVotesCount(){
		this.votesCount++;
	}
}
