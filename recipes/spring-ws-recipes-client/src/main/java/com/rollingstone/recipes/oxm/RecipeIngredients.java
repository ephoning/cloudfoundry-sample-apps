
package com.rollingstone.recipes.oxm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeDetailId"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}ingredientName"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}uom"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}quantity"/>
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
    "recipeDetailId",
    "ingredientName",
    "uom",
    "quantity"
})
@XmlRootElement(name = "recipe_ingredients")
public class RecipeIngredients {

    protected int recipeDetailId;
    @XmlElement(required = true)
    protected String ingredientName;
    @XmlElement(required = true)
    protected String uom;
    @XmlElement(required = true)
    protected String quantity;

    /**
     * Gets the value of the recipeDetailId property.
     * 
     */
    public int getRecipeDetailId() {
        return recipeDetailId;
    }

    /**
     * Sets the value of the recipeDetailId property.
     * 
     */
    public void setRecipeDetailId(int value) {
        this.recipeDetailId = value;
    }

    /**
     * Gets the value of the ingredientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets the value of the ingredientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIngredientName(String value) {
        this.ingredientName = value;
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUom() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUom(String value) {
        this.uom = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

}
