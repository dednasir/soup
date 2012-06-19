package controllers;

import java.util.*;

public class ShoppingCart {

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
            totalPrice = totalPrice + p.getPrice();
        }
        return totalPrice;
    }

    public void removeProduct(Soups p) {
        SoupList.remove(p);
    }
}
