package notifiers;
 
import play.*;
import play.mvc.*;
import java.util.*;

import models.SoupUser;
 
public class Mails extends Mailer {
 
   public static void welcome(SoupUser user) {
      setSubject("Welcome %s", user.toString());
      addRecipient(user.email);
      setFrom("Me <me@me.com>");
      //addAttachment(Play.getFile("rules.pdf"));
      send(user);
   }
 
   public static void lostPassword(SoupUser user) {
      String newpassword = "xvcbis";
      setFrom("Soup <dednasir@yahoo.com>");
      setSubject("Your password has been reset");
      addRecipient(user.email);
      send(user, newpassword);
   }
 
}