package models;

import javax.persistence.Entity;

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class SoupIngredients extends Model {

    @Required
    @MaxSize(15)
    @MinSize(4)
    public String Name;
    
    @Required
    @MaxSize(250)
    @MinSize(5)
    public String Description;
    
    @Required
    @MinSize(1)
    public double value;
    
    @Required
    @MaxSize(5)
    @MinSize(1)
    public int IngID;
    
    public SoupIngredients(String name, String desc, double value, int ID) {
        this.Name = name;
        this.Description = desc;
        this.value = value;
        this.IngID = ID;
    }
    public SoupIngredients(SoupIngredients ing) {
        this.Name = ing.Name;
        this.Description = ing.Description;
        this.value = ing.value;
        this.IngID = ing.IngID;
    }
    public static SoupIngredients find(int ingID) {
        return find("byIngID", ingID).first();
    }
}
