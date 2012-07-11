package controllers;

import java.io.Serializable;
import java.util.*;

import play.cache.Cache;
import play.mvc.Controller;

public class ShoppingCart extends Controller implements Serializable {

    private ArrayList SoupList;
    private int customerID;

    public ShoppingCart(int customerID) {
        this.customerID = customerID;
        SoupList = new ArrayList();
    }

    public void addProduct(Soups p) {
        SoupList.add(p);
    }

    public String getContents() {
        String s = "";
        // Get the description of each Product in this ShoppingCart
        // and append it to the end of a String, producing one long
        // string describing all of the Products. 
        for (int i=0; i<SoupList.size(); i++) {
            Object obj = SoupList.get(i);
            Soups p = (Soups)obj;
            s = s + "\n" + p.toString();
        }
        return s;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemCount() {
        return SoupList.size();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i=0; i<SoupList.size(); i++) {
            Object obj = SoupList.get(i);
            Soups p = (Soups)obj;
            totalPrice = totalPrice + p.getTotalPrice();
        }
        return totalPrice;
    }

    public boolean removeProduct(String Soupid) {
        int id = Integer.parseInt(Soupid);
        for(int count=0;count < SoupList.size(); count++) {
            Object obj = SoupList.get(count);
            Soups objSoup = (Soups)obj;
            if(objSoup.getSoupID() == id) {
                SoupList.remove(objSoup);
                return true;
            }
        }
        return false;
    }
    
    public boolean RemoveIngredient(String Soupid,String IngID){
        
        int id = Integer.parseInt(Soupid);
        int iid = Integer.parseInt(IngID);
        for(int count=0;count < SoupList.size(); count++) {
            Object obj = SoupList.get(count);
            Soups objSoup = (Soups)obj;
            if(objSoup.getSoupID() == id) {
                if(deleteIngredient(objSoup,IngID))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
    
    public boolean deleteIngredient(Soups objSoup, String IngID){
        
        int iid = Integer.parseInt(IngID);
        ArrayList objArray =  objSoup.getIngredientList();
        for(int count=0;count < objArray.size(); count++) {
            Object obj = objArray.get(count);
            Ingredient objIngredient = (Ingredient)obj;
            if(objIngredient.getIngID() == iid) {
                objArray.remove(objIngredient);
                return true;
            }
        }
        return false;
    }
    
    public static void setQuantity(String id,int quantity){
    	int soupid = Integer.parseInt(id);
    	double subtotal=0.0,total=0.0;
    	ShoppingCart objShoppingCart;
    	if(Cache.get("ShoppingCart", ShoppingCart.class) != null ) {
            objShoppingCart = Cache.get("ShoppingCart", ShoppingCart.class);
	    	for(int count=0;count < objShoppingCart.SoupList.size(); count++) {
	            Object obj = objShoppingCart.SoupList.get(count);
	            Soups objSoup = (Soups)obj;
	            if(objSoup.getSoupID() == soupid) {
	            	objSoup.setSoupQuantitiy(quantity);
	            	subtotal = objSoup.getTotalPrice();
	            }
	        }
        	total = objShoppingCart.getTotalPrice();
        	renderText(subtotal +"," + total);
    	}
	    renderText("id" + id + "quantity" + quantity);
    }
    public String setSoupQuantity(String id,int quantity){
    	 
    	int soupid = Integer.parseInt(id);	
        for(int count=0;count < SoupList.size(); count++) {
            Object obj = SoupList.get(count);
            Soups objSoup = (Soups)obj;
            if(objSoup.getSoupID() == soupid) {
            	objSoup.setSoupQuantitiy(quantity);
                renderText("what");
            }
        }
        return "shopping function";
    }
}
