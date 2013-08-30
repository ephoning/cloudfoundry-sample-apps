package com.rollingstone.recipes.domain;

import java.sql.Clob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@XmlRootElement(name = "recipe")
@Entity
@Table(name="RECIPE")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECIPEID")
	int recipeId;
	
	@Column(name="RECIPE_NAME")
	String recipeName;
	
	@Column(name="DESCRIPTION")
	String recipeDescription;
	
	@Column(name="CREATED_ON")
	Date createdOn;
	
	@Column(name="CREATED_BY")
	String createdBy;
	
	@Column(name="RECIPETYPE")
	String recipeType;
	
	@Column(name="VISITOR_COUNT")
	int visitorCount;
	
	@Column(name="PROCESS")
	Clob process;

	@OneToMany(mappedBy="recipe", fetch=FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	List<RecipeIngredients> ingredients;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public int getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}

	@XmlJavaTypeAdapter(ClobAdapter.class)
	public Clob getProcess() {
		return process;
	}

	public void setProcess(Clob process) {
		this.process = process;
	}

	public List<RecipeIngredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredients> ingredients) {
		this.ingredients = ingredients;
	}
}
