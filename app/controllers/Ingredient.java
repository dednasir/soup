package controllers;

public class Ingredient {

    private int IngredientID;
    private String IngredientName;
    private double IngredientPrice;
    private String IngImage;

    public Ingredient(int IngID,String IngName,double Ingprice) {
        this.IngredientID = IngID;
        this.IngredientName = IngName;
        this.IngredientPrice = Ingprice;
        this.IngImage = null;
    }
    
    public double getPrice() {
        // TODO Auto-generated method stub
        return IngredientPrice;
    }
    public String getName() {
        // TODO Auto-generated method stub
        return IngredientName;
    }
    public int getIngID() {
        // TODO Auto-generated method stub
        return IngredientID;
    }
}
