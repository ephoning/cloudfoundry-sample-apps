package com.rollingstone.recipes.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Every service must return this object type
 * The AGSCServiceResult will encapsulate the 
 * <br/>Model as a Result along with the version, 
 * <br/>errorCode as the Standard Error Codes as defined by the AGSC Service Error Codes , 
 * <br/>errorMessage as the Custom Error Messages for the UI, 
 * <br/>CurrentPageIndex as the index of the current page in the UI,
 * <br/>pageSize as the number of rows to be shown on a page as requested by the UI, 
 * <br/>totalItems as count of rows in the Query ResultSet.
 * @param <T> - Type of the Model Class the Service Method is returning to the user as the result 
 */
public  class ResponseObject<T extends Object> {
	/**
	 * The version of service that returned this object
	 */
	private String version;
	/**
	 * The error code associated with the service call
	 */
	private int errorCode;
	/**
	 * The error message
	 */
	private String errorMessage;
	/**
	 * The list of model objects encapsulated by this result object
	 */
	private List<T> listOfModels;
	/**
	 * The current page
	 */
	private int currentPageIndex;
	/**
	 * Size of page
	 */
	private int pageSize;
	/**
	 * Total number of items in all
	 */
	private int totalItems;
	/**
	 * Accessor for the version
	 * @return String
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * Mutator for the version
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * Accessor for the list of models encapsulated within this result object
	 * @return List of Mode object types
	 */
	public List<T> getListOfModels() {
		return listOfModels;
	}
	/**
	 * Mutator for the list of models to be encapsulated within this result object
	 * @param listOfModels A list of model object types
	 */
	public void setListOfModels(List<T> listOfModels) {
		this.listOfModels = listOfModels;
	}
	/**
	 * Accessor for current page index
	 * @return int
	 */
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	/**
	 * Mutator for the current page index
	 * @param currentPageIndex
	 */
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	/**
	 * Accessor for the page size
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * Mutator for the page size
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * Accessor for total number of items
	 * Please note: This represents all items. For example, you may have 100 employees in the database, but 
	 * you are showing only 1-10 , thus, total items is 100, current page is 0 and page size is 10
	 * @return int
	 */
	public int getTotalItems() {
		return totalItems;
	}
	/**
	 * Mutator for the total items available in the database
	 * @param totalItems
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	/**
	 * Accessor for the error code
	 * @return int
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * Mutator or the error code
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * Accessor for the string message
	 * @return String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * Mutator for the string message
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * Get the number of model elements embedded within this result object
	 * @return int
	 */
	public int getCountOfModelElements() {
		if(listOfModels == null){
			return 0;
		}
		return listOfModels.size();
		
	}
	/**
	 * Add a model object to the encapsulated list
	 * @param model The model object of type AbstractAGSCModel
	 */
	public  void addModel(T  model){
		if ( this.listOfModels == null){
			listOfModels = new ArrayList<T>();	
		}
		listOfModels.add(model);
	}
}
