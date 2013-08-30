
package com.rollingstone.recipes.oxm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rollingstone.recipes.oxm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecipeId_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "recipeId");
    private final static QName _RecipeName_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "recipeName");
    private final static QName _Code_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "code");
    private final static QName _RecipeDetailId_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "recipeDetailId");
    private final static QName _IngredientName_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "ingredientName");
    private final static QName _CreatedBy_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "createdBy");
    private final static QName _Uom_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "uom");
    private final static QName _RecipeType_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "recipeType");
    private final static QName _Process_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "process");
    private final static QName _VisitorCount_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "visitorCount");
    private final static QName _EditType_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "editType");
    private final static QName _TotalRecord_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "totalRecord");
    private final static QName _Quantity_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "quantity");
    private final static QName _RecipeDescription_QNAME = new QName("http://binit.blogspot.com/ws/schema/recipe", "recipeDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rollingstone.recipes.oxm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecipeRequest }
     * 
     */
    public GetRecipeRequest createGetRecipeRequest() {
        return new GetRecipeRequest();
    }

    /**
     * Create an instance of {@link GetRecipeResponse }
     * 
     */
    public GetRecipeResponse createGetRecipeResponse() {
        return new GetRecipeResponse();
    }

    /**
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link EditRecipeRequest }
     * 
     */
    public EditRecipeRequest createEditRecipeRequest() {
        return new EditRecipeRequest();
    }

    /**
     * Create an instance of {@link DeleteRecipeRequest }
     * 
     */
    public DeleteRecipeRequest createDeleteRecipeRequest() {
        return new DeleteRecipeRequest();
    }

    /**
     * Create an instance of {@link EditRecipeResponse }
     * 
     */
    public EditRecipeResponse createEditRecipeResponse() {
        return new EditRecipeResponse();
    }

    /**
     * Create an instance of {@link DeleteRecipeResponse }
     * 
     */
    public DeleteRecipeResponse createDeleteRecipeResponse() {
        return new DeleteRecipeResponse();
    }

    /**
     * Create an instance of {@link RecipeIngredients }
     * 
     */
    public RecipeIngredients createRecipeIngredients() {
        return new RecipeIngredients();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "recipeId")
    public JAXBElement<Integer> createRecipeId(Integer value) {
        return new JAXBElement<Integer>(_RecipeId_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "recipeName")
    public JAXBElement<String> createRecipeName(String value) {
        return new JAXBElement<String>(_RecipeName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "recipeDetailId")
    public JAXBElement<Integer> createRecipeDetailId(Integer value) {
        return new JAXBElement<Integer>(_RecipeDetailId_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "ingredientName")
    public JAXBElement<String> createIngredientName(String value) {
        return new JAXBElement<String>(_IngredientName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "createdBy")
    public JAXBElement<String> createCreatedBy(String value) {
        return new JAXBElement<String>(_CreatedBy_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "uom")
    public JAXBElement<String> createUom(String value) {
        return new JAXBElement<String>(_Uom_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "recipeType")
    public JAXBElement<String> createRecipeType(String value) {
        return new JAXBElement<String>(_RecipeType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "process")
    public JAXBElement<String> createProcess(String value) {
        return new JAXBElement<String>(_Process_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "visitorCount")
    public JAXBElement<Integer> createVisitorCount(Integer value) {
        return new JAXBElement<Integer>(_VisitorCount_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "editType")
    public JAXBElement<String> createEditType(String value) {
        return new JAXBElement<String>(_EditType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "totalRecord")
    public JAXBElement<Integer> createTotalRecord(Integer value) {
        return new JAXBElement<Integer>(_TotalRecord_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "quantity")
    public JAXBElement<String> createQuantity(String value) {
        return new JAXBElement<String>(_Quantity_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://binit.blogspot.com/ws/schema/recipe", name = "recipeDescription")
    public JAXBElement<String> createRecipeDescription(String value) {
        return new JAXBElement<String>(_RecipeDescription_QNAME, String.class, null, value);
    }

}
