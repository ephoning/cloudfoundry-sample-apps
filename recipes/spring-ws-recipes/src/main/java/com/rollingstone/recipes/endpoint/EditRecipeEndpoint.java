package com.rollingstone.recipes.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.oxm.EditRecipeRequest;
import com.rollingstone.recipes.oxm.EditRecipeResponse;
import com.rollingstone.recipes.service.RecipeService;


/**
 * Handles recipe requests. 
 * <p>
 *<pre>
 * @Endpoint: same as Spring MVC's @Controller. 
 * @PayloadRoot: same as Spring MVC's @RequestMapping</pre>
 */
@Endpoint
public class EditRecipeEndpoint {

	protected static Logger logger = Logger.getLogger(EditRecipeEndpoint.class);

	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	public static final String NAMESPACE_URI = "http://binit.blogspot.com/ws/schema/recipe";

	public static final String REQUEST_LOCAL_NAME = "editRecipeRequest";

	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public EditRecipeResponse editRecipe( @RequestPayload EditRecipeRequest editReipeRequest) {
		try {
			String editType = editReipeRequest.getEditType();
			Recipe recipe = editReipeRequest.getRecipe();
			if (editType.equals("ADD")){
				logger.debug("Add operation");
				recipeService.createRecipe(recipe);				
			}else{
				logger.debug("Edit operation");
				recipeService.saveRecipe(recipe);
			}
		}  catch (Exception e) {
			logger.error("Unable to save recipe");
			EditRecipeResponse response = new EditRecipeResponse();
			response.setCode("FAILURE");
			return response;
		}
		
		EditRecipeResponse response = new EditRecipeResponse();
		response.setCode("SUCCESS");

		return response;
	}
}
