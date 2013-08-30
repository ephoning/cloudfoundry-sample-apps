package com.rollingstone.recipes.dao;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.domain.RecipeIngredients;
import com.rollingstone.recipes.utils.HibernateUtil;

/*
 * Author Binit Datta
 * 
 * Hibernate JPA DAO Impl class
 */

@Repository
public class RecipeHibernateDaoImpl extends AbstractDAO implements IRecipeDao {

	Logger logger = Logger.getLogger(RecipeHibernateDaoImpl.class);

	@Autowired HibernateUtil hibernateUtil;
	
	@SuppressWarnings("static-access")
	@Override
	public List<Recipe> searchRecipe(String recipeName, String recipeType) {
		SessionFactory sf = hibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Recipe.class);
        if (recipeName != null && !recipeName.equals("NA")){
        	c.add(Restrictions.like("recipeName", "%"+recipeName+"%"));
        }
        if (recipeType != null && !recipeType.equals("NA")){
        	c.add(Restrictions.like("recipeType", "%"+recipeType+"%"));
        }
        List<Recipe> recipesList = c.list();
        logger.debug("Total result found: "+recipesList.size());
        session.close();
        
        return recipesList;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Recipe.class);
        List<Recipe> recipesList = c.list();
        session.close();
        for (Recipe rcp : recipesList){
        	logger.debug("Name: "+rcp.getRecipeName());
        	Clob proces = rcp.getProcess();
        	String clobStr = null;
        	
			try {
				clobStr = proces.getSubString(1, (int) proces.length());
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	logger.debug("Process: "+clobStr);
        }
        return recipesList;
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		SessionFactory sf = hibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<RecipeIngredients> ingredients = (List<RecipeIngredients>) recipe.getIngredients();

        	for (Iterator<RecipeIngredients> ingredientItr = ingredients.iterator(); ingredientItr.hasNext(); ){
        		RecipeIngredients ingredient = ingredientItr.next();
        		ingredient.setRecipe(recipe);
        	}
        	
        	session.update(recipe);
        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        }finally{
            session.close();
        }
   	
        return recipe;
	}

	@Override
	public boolean deleteRecipe(int recipeId) throws Exception {
		SessionFactory sf = hibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try{
        	Recipe recipe = (Recipe) session.get(Recipe.class, recipeId);
    		session.delete(recipe);
    		session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        	throw e;
        }finally{
            session.close();
        }

        return true;
		
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		SessionFactory sf = hibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<RecipeIngredients> ingredients = (List<RecipeIngredients>) recipe.getIngredients();

        	for (Iterator<RecipeIngredients> ingredientItr = ingredients.iterator(); ingredientItr.hasNext(); ){
        		RecipeIngredients ingredient = ingredientItr.next();
        		ingredient.setRecipe(recipe);
        	}
        	
        	session.save(recipe);
        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        
        }finally{
            session.close();
        }
    	return recipe;
	}
}
