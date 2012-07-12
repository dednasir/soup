package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.data.binding.As;
import play.data.validation.Email;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Blog extends Model {

	    @Required
	    @MaxSize(15)
	    @MinSize(4)
	    //@Match(value="^\\w*$", message="Not a valid Name")
	    public String BlogName;
	    
	    
	    //@Match(value="^\\w*$", message="Not a valid Name")
	    public String Desc;
	    
	    @Required
	    @MaxSize(25)
	    @MinSize(1)
	    public int BlogID;
	    
	    public Blog(String BlogName, int BlogID, String Desc) {
	        this.BlogName = BlogName;
	        this.BlogID =BlogID;
	        this. Desc = Desc;
	    }
	    
	    public Blog() {
	        this.BlogName = null;
	        this.Desc = null;
	        this.BlogID = 0;
	    }
	    public Blog(Blog bl) {
	        this.BlogName = bl.BlogName;
	        this.Desc = bl.Desc;
	        this.BlogID = bl.BlogID;
	    }

	    public String toString() 
	    {
	        return BlogName +" "+ Desc;
	    }
	    
	    public static Blog find(int BlogID) {
	        return find("byBlogID", BlogID).first();
	    }
}