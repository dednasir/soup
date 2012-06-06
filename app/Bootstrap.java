import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
 

    @SuppressWarnings("deprecation")
    public void doJob() {
        // Check if the database is empty
        if(SoupUser.count() == 0) {
            Fixtures.load("data.yml");
        }
    }
}