package com.fci.itdl.model;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Offer {

	private String offerID;
	private String category;
	private String content;
	private String startDate;
	private String endDate;
	
	public Offer(String offerID, String categoryID, String content, String startDate, String endDate)
	{
		this.offerID = offerID;
		this.category = categoryID;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Offer(String categoryID, String content, String startDate, String endDate)
	{
		this.category = categoryID;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getCategoryID() {
		return category;
	}

	public void setCategoryID(String categoryID) {
		this.category = categoryID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public static Offer getOffer(String offerID)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query gaeQuery = new Query("Offer");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) 
		{
			if (entity.getProperty("OfferID").toString().equals(offerID)) 
			{
				String offerCategory = entity.getProperty("CategoryID").toString();
				Query gaeQuery1 = new Query("Category");
				PreparedQuery pq1 = datastore.prepare(gaeQuery1);
				for (Entity entity1 : pq1.asIterable()) 
				{
					if (entity1.getProperty("CategoryID").toString().equals(offerCategory)) 
					{
						String category = entity1.getProperty("CategoryName").toString();
						Offer returnedOffer = new Offer(entity.getProperty("OfferID").toString(), category, entity.getProperty("Content").toString(), entity.getProperty("StartDate").toString(), entity.getProperty("EndDate").toString());
						return returnedOffer;
					}
				}
			}
		}
		return null;
		
	}
	
	public static boolean deleteOffer(String offerID, String storeID)
	{
		Offer returnedOffer = getOffer(offerID);
		int categoryID = 0;
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query gaeQuery = new Query("Category");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) 
		{
			if (entity.getProperty("CategoryName").toString().equals(returnedOffer.getCategoryID())) 
			{
				categoryID = Integer.parseInt(entity.getProperty("CategoryID").toString());
				break;
			}
		}
		Entity offer = new Entity("Offer", Integer.parseInt(offerID));
		offer.setProperty("StoreID", storeID);
		offer.setProperty("OfferID", Integer.parseInt(offerID));
	    offer.setProperty("StartDate", returnedOffer.getStartDate());
		offer.setProperty("EndDate", returnedOffer.getEndDate());
		offer.setProperty("Content", returnedOffer.getContent());
		offer.setProperty("Status", "OFF");
		offer.setProperty("CategoryID", categoryID);
		
		datastore.put(offer);
		return true;
	}
	
	public static boolean updateOffer(Offer updatedOffer, String storeID)
	{
		int categoryID = 0;
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query gaeQuery = new Query("Category");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) 
		{
			if (entity.getProperty("CategoryName").toString().equals(updatedOffer.getCategoryID())) 
			{
				categoryID = Integer.parseInt(entity.getProperty("CategoryID").toString());
				break;
			}
		}
		Entity offer = new Entity("Offer", Integer.parseInt(updatedOffer.getOfferID()));
		offer.setProperty("StoreID", storeID);
		offer.setProperty("OfferID", Integer.parseInt(updatedOffer.getOfferID()));
	    offer.setProperty("StartDate", updatedOffer.getStartDate());
		offer.setProperty("EndDate", updatedOffer.getEndDate());
		offer.setProperty("Content", updatedOffer.getContent());
		offer.setProperty("Status", "ON");
		offer.setProperty("CategoryID", categoryID);
		
		datastore.put(offer);
		return true;
	}
	
	public Boolean saveOffer(String storeEmail)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    	int categoryID = 1;
//    	Entity category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 1);
//	    category.setProperty("CategoryName", "Arts and Entertainments");
//	    datastore.put(category);
//	    
//	    categoryID = 2;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 2);
//	    category.setProperty("CategoryName", "Movies");
//	    datastore.put(category);
//	    
//	    categoryID = 3;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 3);
//	    category.setProperty("CategoryName", "Music");
//	    datastore.put(category);
//	    
//	    categoryID = 4;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 4);
//	    category.setProperty("CategoryName", "Food and drinks");
//	    datastore.put(category);
//	    
//	    categoryID = 5;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 5);
//	    category.setProperty("CategoryName", "Technology");
//	    datastore.put(category);
//	    
//	    categoryID = 6;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 6);
//	    category.setProperty("CategoryName", "Sports");
//	    datastore.put(category);
//	    
//	    categoryID = 7;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 7);
//	    category.setProperty("CategoryName", "Health");
//	    datastore.put(category);
//	    
//	    categoryID = 8;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 8);
//	    category.setProperty("CategoryName", "Religion");
//	    datastore.put(category);
//	    
//	    categoryID = 9;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 9);
//	    category.setProperty("CategoryName", "Education");
//	    datastore.put(category);
//	    
//	    categoryID = 10;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 10);
//	    category.setProperty("CategoryName", "Pets and animals");
//	    datastore.put(category);
//	    
//	    categoryID = 11;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 11);
//	    category.setProperty("CategoryName", "Fashion");
//	    datastore.put(category);
//	    
//	    categoryID = 12;
//    	category = new Entity("Category", categoryID);
//		category.setProperty("CategoryID", 12);
//	    category.setProperty("CategoryName", "Reading");
//	    datastore.put(category);
	    
		Query gaeQuery = new Query("Category");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) 
		{
			if (entity.getProperty("CategoryName").toString().equals(category)) 
			{
				categoryID = Integer.parseInt(entity.getProperty("CategoryID").toString());
				break;
			}
		}
		Query gaeQuery1 = new Query("Offer");
		PreparedQuery pq1 = datastore.prepare(gaeQuery1);
		int size = pq1.countEntities(FetchOptions.Builder.withDefaults());
		Entity offer = new Entity("Offer", (size+1));
		offer.setProperty("StoreID", storeEmail);
		offer.setProperty("OfferID", (size+1));
	    offer.setProperty("StartDate", startDate);
		offer.setProperty("EndDate", endDate);
		offer.setProperty("Content", content);
		offer.setProperty("Status", "ON");
		offer.setProperty("CategoryID", categoryID);
		
		datastore.put(offer);
		return true;
	}
}
