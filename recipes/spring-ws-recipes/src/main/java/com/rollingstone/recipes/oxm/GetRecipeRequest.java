package com.rollingstone.recipes.oxm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recipeName",
    "recipeType"
})
@XmlRootElement(name = "getRecipeRequest")
public class GetRecipeRequest {

    @XmlElement(required = true)
    protected String recipeName;
    @XmlElement(required = true)
    protected String recipeType;

    public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String value) {
        this.recipeName = value;
    }
}
