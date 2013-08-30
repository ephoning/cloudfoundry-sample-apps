package com.rollingstone.recipes.oxm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.rollingstone.recipes.domain.Recipe;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "editType",
    "recipe"
})
@XmlRootElement(name = "editRecipeRequest")
public class EditRecipeRequest {

    @XmlElement(required = true)
    protected String editType;
    @XmlElement(required = true)
    protected Recipe recipe;

    /**
     * Gets the value of the editType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditType() {
        return editType;
    }

    /**
     * Sets the value of the editType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditType(String value) {
        this.editType = value;
    }

    /**
     * Gets the value of the recipe property.
     * 
     * @return
     *     possible object is
     *     {@link Recipe }
     *     
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets the value of the recipe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recipe }
     *     
     */
    public void setRecipe(Recipe value) {
        this.recipe = value;
    }

}
