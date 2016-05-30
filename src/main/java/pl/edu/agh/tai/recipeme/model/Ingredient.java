package pl.edu.agh.tai.recipeme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Id;
	
	@NotNull
	private String name;
	
	@NotNull
	@ManyToOne
	private Category category;
	
	@NotNull
	private Boolean isApproved;

	
	public Ingredient(String name, Category category, Boolean isApproved) {
		super();
		this.name = name;
		this.category = category;
		this.isApproved = isApproved;
	}
	
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
