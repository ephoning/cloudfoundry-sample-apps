
package com.rollingstone.recipes.oxm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recipeId"
})
@XmlRootElement(name = "deleteRecipeRequest")
public class DeleteRecipeRequest {

    protected int recipeId;

    /**
     * Gets the value of the recipeId property.
     * 
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the value of the recipeId property.
     * 
     */
    public void setRecipeId(int value) {
        this.recipeId = value;
    }

}
