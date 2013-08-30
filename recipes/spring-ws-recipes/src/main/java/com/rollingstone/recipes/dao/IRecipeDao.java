package com.rollingstone.recipes.dao;

import java.util.List;

/*
 * Author Binit Datta
 * 
 * Base interface to be implemented 
 */
import com.rollingstone.recipes.domain.Recipe;

public interface IRecipeDao {

	List<Recipe> searchRecipe(String recipeName, String recipeType);
	
	List<Recipe> getAllRecipes();
	
	Recipe saveRecipe(Recipe recipe);
	
	boolean deleteRecipe(int recipeId) throws Exception;
	
	Recipe createRecipe(Recipe recipe);
}
