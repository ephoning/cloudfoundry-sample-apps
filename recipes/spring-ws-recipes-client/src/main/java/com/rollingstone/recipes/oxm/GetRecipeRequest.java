
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
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeName"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeType"/>
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
    "recipeName",
    "recipeType"
})
@XmlRootElement(name = "getRecipeRequest")
public class GetRecipeRequest {

    @XmlElement(required = true)
    protected String recipeName;
    @XmlElement(required = true)
    protected String recipeType;

    /**
     * Gets the value of the recipeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the value of the recipeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeName(String value) {
        this.recipeName = value;
    }

    /**
     * Gets the value of the recipeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeType() {
        return recipeType;
    }

    /**
     * Sets the value of the recipeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeType(String value) {
        this.recipeType = value;
    }

}
