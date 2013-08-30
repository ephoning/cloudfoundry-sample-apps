package com.rollingstone.recipes.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.oxm.GetRecipeRequest;
import com.rollingstone.recipes.oxm.GetRecipeResponse;
import com.rollingstone.recipes.service.RecipeService;


/**
 * Handles recipe requests. 
 * <p>
 *<pre>
 * @Endpoint: same as Spring MVC's @Controller. 
 * @PayloadRoot: same as Spring MVC's @RequestMapping</pre>
 */
@Endpoint
public class GetRecipeEndpoint {

	protected static Logger logger = Logger.getLogger(GetRecipeEndpoint.class);

	@Resource(name="recipeService")
	private RecipeService recipeService;

	public static final String NAMESPACE_URI = "http://binit.blogspot.com/ws/schema/recipe";

	public static final String REQUEST_LOCAL_NAME = "getRecipeRequest";

	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public GetRecipeResponse getAllRecipe( @RequestPayload GetRecipeRequest getReipeRequest) {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		GetRecipeResponse response = null;

        try {
			String searchText = getReipeRequest.getRecipeName();
			String recipeType = getReipeRequest.getRecipeType();
			
			if (searchText == null){
				searchText = "NA";
			}
			if (recipeType == null){
				recipeType = "NA";
			}
			
			/*If no searchtext provided, return all result*/
			if (searchText.equals("NA") && recipeType.equals("NA")){
                logger.debug("Get All operation");
				recipeList = recipeService.getAllRecipes();
			}else{
                logger.debug("Get Specific operation");
				recipeList = recipeService.getRecipe(searchText, recipeType);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			response = new GetRecipeResponse();
			response.setCode("FAILURE");
			response.setTotalRecord(0);
			return response;
		}

		response = new GetRecipeResponse();
		response.setRecipe(recipeList);
		response.setCode("SUCCESS");
		response.setTotalRecord(recipeList.size());

		return response;
	}
}
