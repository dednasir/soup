package models;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class SoupUser extends Model {

    @Required
    @MaxSize(15)
    @MinSize(4)
    //@Match(value="^\\w*$", message="Not a valid Name")
    public String FirstName;
    
    @Required
    @MaxSize(15)
    @MinSize(3)
    //@Match(value="^\\w*$", message="Not a valid Name")
    public String LastName;
    
    @Required
    @MaxSize(25)
    @MinSize(5)
    public String Street;
    
    @Required
    @MaxSize(5)
    @MinSize(5)
    @Match(value="^[0-9]+$", message="Not a valid Zip Code")
    public String ZipCode;
    
    @Required
    @MaxSize(15)
    @MinSize(5)
    public String Password;
    
    @Required
    @Email
    public String email;
    
    public boolean isAdmin;
    
    public SoupUser(String name, String password, String username, String email) {
        this.Password = password;
        this.email = email;
        this.FirstName = name;
    }

    public String toString()  {
        return FirstName +" "+ LastName;
    }
    
    public static SoupUser connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
    
    public static SoupUser UserExist(String email) {
        return find("byEmail", email).first();
    }
}
