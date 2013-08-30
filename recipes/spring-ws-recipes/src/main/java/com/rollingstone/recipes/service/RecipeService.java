package com.rollingstone.recipes.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.rollingstone.recipes.dao.IRecipeDao;
import com.rollingstone.recipes.domain.Recipe;

@Service("recipeService")
//@Transactional
public class RecipeService implements IRecipeService {

	protected static Logger logger = Logger.getLogger(RecipeService.class);
	
	IRecipeDao recipeDao;
	
	@Autowired
	@Required
	public void setRecipeDao(IRecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
	
	@Override
	public List<Recipe> getRecipe(String recipeName, String recipeType) {
		return recipeDao.searchRecipe(recipeName, recipeType);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> allResults = recipeDao.getAllRecipes();
		return allResults;
	}

	@Override
	public void saveRecipe(Recipe recipe) {
		recipeDao.saveRecipe(recipe);
	}

	@Override
	public void deleteRecipe(int recipeId) throws Exception {
		recipeDao.deleteRecipe(recipeId);
	}

	@Override
	public void createRecipe(Recipe recipe) {
		recipeDao.createRecipe(recipe);
	}
}
