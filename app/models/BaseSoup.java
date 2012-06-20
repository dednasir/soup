package models;

import javax.persistence.Entity;

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class BaseSoup extends Model {
    
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
    public int SoupID;
    
    public BaseSoup(String name, String desc, double value, int ID) {
        this.Name = name;
        this.Description = desc;
        this.value = value;
        this.SoupID = ID;
    }
    public BaseSoup() {
        this.Name = null;
        this.Description = null;
        this.value = 0;
        this.SoupID = 0;
    }
    public BaseSoup(BaseSoup bs) {
        this.Name = bs.Name;
        this.Description = bs.Description;
        this.value = bs.value;
        this.SoupID = bs.SoupID;
    }
    public static BaseSoup find(int soupID) {
        return find("bySoupID", soupID).first();
    }
}
