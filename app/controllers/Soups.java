package controllers;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.groovy.tools.shell.ParseCode;

public class Soups implements Serializable{
    
    private int SoupID;
    private String SoupName;
    private double SoupPrice;
    private String SoupSize;
    private ArrayList IngredientList;
    

    public Soups(int soupID,String soupname,double price) {
        this.SoupID = soupID;
        this.SoupName = soupname;
        this.SoupPrice = price;
        this.SoupSize = null;
        IngredientList = new ArrayList();
    }

    public int getSoupID() {
        return SoupID;
    }
    
    public String getSoupName() {
        return SoupName;
    }
    
    public String getSoupSize() {
        return SoupSize;
    }
    
    public void setSoupSize(String s) {
        SoupSize = s;
    }
    
    public double getBaseSoupPrice() {
        return SoupPrice;
    }
    
    public void addIngredient(Ingredient I) {
        IngredientList.add(I);
    }
    
    public ArrayList getIngredientList(){
        return IngredientList;
    }
    
    public boolean RemoveIngredient(String id){
        for(int count=0;count <= IngredientList.size();count++) {
            Object obj = IngredientList.get(count);
            Ingredient objIng = (Ingredient)obj;
            if(objIng.getIngID() == Integer.parseInt(id)) {
                IngredientList.remove(objIng);
                return true;
            }
        }
        return false;
    }

    
    public double getTotalPrice() {
        double totalPrice = 0;
        // Get the price of each Product in this ShoppingCart and
        // add it to the totalPrice.  Notice that polymorphism allows
        // this method to work for both Products and DiscountProducts.
        for (int i=0; i<this.IngredientList.size(); i++) {
            Object obj = this.IngredientList.get(i);
            Ingredient p = (Ingredient)obj;
            totalPrice = totalPrice + p.getPrice();
        }
        return totalPrice + this.SoupPrice;
    }

}
