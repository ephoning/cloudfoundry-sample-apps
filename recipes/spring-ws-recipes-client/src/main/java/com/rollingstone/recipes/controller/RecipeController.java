package com.rollingstone.recipes.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.rollingstone.recipes.oxm.DeleteRecipeRequest;
import com.rollingstone.recipes.oxm.DeleteRecipeResponse;
import com.rollingstone.recipes.oxm.EditRecipeRequest;
import com.rollingstone.recipes.oxm.EditRecipeResponse;
import com.rollingstone.recipes.oxm.GetRecipeRequest;
import com.rollingstone.recipes.oxm.GetRecipeResponse;
import com.rollingstone.recipes.oxm.Recipe;
import com.rollingstone.recipes.oxm.RecipePort;

/**
 * Handles and retrieves the Recipe request
 */
@Controller
public class RecipeController {

	protected static Logger logger = Logger.getLogger(RecipeController.class);

	@Resource(name="recipeJaxProxyService")
	private RecipePort recipeJaxProxyService;
	
	/**
	 * Handles the get recipe request
	 */
//    @RequestMapping(value = "/recipe/getrecipe.view", method = RequestMethod.GET, consumes={"application/json", "text/html", "text/xml"}, produces={"application/json", "text/html", "text/xml"})
    @RequestMapping(value = "/recipe/getrecipe.view", method = RequestMethod.GET, consumes={"application/x-www-form-urlencoded"}, produces={"application/json"})
	@ResponseBody
	public GetRecipeResponse getRecipe(@RequestParam("recipeName") String recipeName, @RequestParam("recipeType") String recipeType) {
		GetRecipeRequest request = new GetRecipeRequest();
		GetRecipeResponse response = null;

        logger.debug("Get recipe response with: " + recipeName + " / " + recipeType);
		request.setRecipeName(recipeName);
		request.setRecipeType(recipeType);
		
		if (recipeName==null || recipeType==null){
			response = new GetRecipeResponse();
			response.setCode("FAILURE");
			response.setTotalRecord(0);
			return response;
		}
		
		try {
			response = recipeJaxProxyService.getRecipe(request);
			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return response;
	}
	
	/**
	 * Handles the edit recipe request
	 */
	@RequestMapping(value = "/recipe/editRecipe.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public EditRecipeResponse editRecipe(@RequestBody Recipe recipe, @RequestParam String reqType) {
		EditRecipeRequest request = new EditRecipeRequest();
		EditRecipeResponse response = null;

		if (reqType.equals("ADD")){
			request.setEditType("ADD");
		}else if (reqType.equals("UPDATE")){
			request.setEditType("UPDATE");
		}
		request.setRecipe(recipe);

		try {
			response = recipeJaxProxyService.editRecipe(request);
			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return response;
	}

	/**
	 * Handles the add recipe request
	 */
	@RequestMapping(value = "/addRecipe", method = RequestMethod.GET,  consumes={"text/html"}, produces={"text/xml"})
	@ResponseBody
	public EditRecipeResponse addRecipe(@RequestBody Recipe recipe) {
		EditRecipeRequest request = new EditRecipeRequest();
		EditRecipeResponse response = null;

		request.setEditType("ADD");
		request.setRecipe(recipe);
		try {
			response = recipeJaxProxyService.editRecipe(request);

			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return response;
	}

	/**
	 * Handles the delete recipe request
	 */
	@RequestMapping(value = "/recipe/remove.do", method = RequestMethod.GET)
	@ResponseBody
	public DeleteRecipeResponse deleteRecipe(@RequestParam("recipeId") String recipeId) {
		DeleteRecipeRequest request = new DeleteRecipeRequest();
		DeleteRecipeResponse response = null;

		request.setRecipeId(Integer.parseInt(recipeId));
		try {
			response = recipeJaxProxyService.deleteRecipe(request);
			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return response;
		
	}

}