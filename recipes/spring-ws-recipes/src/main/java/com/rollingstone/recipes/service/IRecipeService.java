package com.rollingstone.recipes.service;

import java.util.List;

import com.rollingstone.recipes.domain.Recipe;

public interface IRecipeService {

	List<Recipe> getRecipe(String recipeName, String recipeType);
	
	List<Recipe> getAllRecipes();
	
	void saveRecipe(Recipe recipe);
	
	void deleteRecipe(int recipeId) throws Exception;
	
	void createRecipe(Recipe recipe);
}
