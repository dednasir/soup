package notifiers;
 
import play.*;
import play.mvc.*;
import java.util.*;

import controllers.Application;

import models.SoupUser;
 
public class Mails extends Mailer {
 
   public static void welcome(SoupUser user) {
      setSubject("Welcome %s", user.toString());
      addRecipient(user.email);
      setFrom("Me <dednasir@yahoo.com>");
      //addAttachment(Play.getFile("rules.pdf"));
      send(user);
      Application.verifyemail();
   }
 
   public static void lostPassword(SoupUser user) {
       //renderText("hello");
       //validation.email(user.email);
      String newpassword = "xvcbis";
      setFrom("Soup <nasir.ali9@hotmail.com>");
      setSubject("Your password has been reset");
      addRecipient(user.email);
      send(user, newpassword);
      Application.confirmemail();
   }
 
}