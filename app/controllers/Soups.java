package controllers;

import java.util.ArrayList;

public class Soups {
    
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

    public void addIngredient(Ingredient I) {
        IngredientList.add(I);
    }

    
    public double getPrice() {
        double totalPrice = 0;
        // Get the price of each Product in this ShoppingCart and
        // add it to the totalPrice.  Notice that polymorphism allows
        // this method to work for both Products and DiscountProducts.
        for (int i=0; i<IngredientList.size(); i++) {
            Object obj = IngredientList.get(i);
            Ingredient p = (Ingredient)obj;
            totalPrice = totalPrice + p.getPrice();
        }
        return totalPrice + this.SoupPrice;
    }

}
