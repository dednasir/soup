package notifiers;
 
import play.*;
import play.mvc.*;

import java.security.SecureRandom;
import java.util.*;

import controllers.Application;

import models.SoupUser;
 
public class Mails extends Mailer {
 
   public static void welcome(SoupUser user) {
      setSubject("Welcome %s", user.toString());
      addRecipient(user.email);
      setFrom("SoupLoveWelcome <dednasir@yahoo.com>");
      //addAttachment(Play.getFile("rules.pdf"));
      send(user);
      Application.verifyemail();
   }
 
   public static void lostPassword(SoupUser user) {
       //renderText("hello");
       //validation.email(user.email);
	   Random ranGen = new SecureRandom();
	   byte[] aesKey = new byte[16]; // 16 bytes = 128 bits
	   ranGen.nextBytes(aesKey);
      String newpassword = aesKey.toString();
      setFrom("SoupLoveLostPassword <nasir.ali9@hotmail.com>");
      setSubject("Your password has been reset");
      addRecipient(user.email);
      SoupUser.setPassowrd(user, newpassword);
      send(user, newpassword);
      Application.confirmemail();
   }
 
}