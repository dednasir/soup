package controllers;

import play.*;
import play.data.validation.Valid;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    @Before
    @Finally
    static void addUser() {
        String user = connected();
        if(user != null) {
            renderArgs.put("user", user);
        }
    }
    
    static String connected() {
//        if(renderArgs.get("user") != null) {
//            return renderArgs.get("user", SoupUser.class);
//        }
//        String username = session.get("user");
//        if(username != null) {
//            return SoupUser.find("byUsername", username).first();
//        } 
//        return null;
        String user = session.get("user");


        if(user != null) {
            return user;
        }
        else
            return null;
    }
    
    
    public static void check(String email, String password) {
        validation.required(email);
        validation.required(password);
        
        if(validation.hasErrors()) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            Application.login();
        }
        SoupUser user = SoupUser.connect(email, password);
        if(user != null) {
            session.put("user", user.FirstName);
            String fullname = user.toString();
            renderTemplate("@Application.index",fullname);
        }
        play.data.validation.Error error = validation.required(user).error;
        if(error != null) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            Application.login();
        }
        

    }
    
    public static void saveUser(@Valid SoupUser users, String verifyPassword ,String email) {
        validation.required(verifyPassword);
        validation.equals(verifyPassword, users.Password).message("Your password doesn't match");
        SoupUser objUser = SoupUser.UserExist(users.email);
       
        if(objUser != null) {
            if(validation.equals(email, objUser.email) != null)
            {
                validation.addError(email, "User already exists");
                validation.keep();
                render("@Application.register", users, verifyPassword);
            }
        }
        if(validation.hasErrors()) {
            //validation.keep();
            render("@Application.register", users, verifyPassword);
        }
        

        users.create();
        session.put("user", users.toString());
        String fullname = users.toString();
        //flash.success("Welcome, " + user.fullname);
        renderTemplate("@Application.index",fullname);
    }
    
    public static void password(String email) {
        validation.email(email);
        if(validation.hasErrors()) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            Application.lostPassword();
        }
//        SimpleEmail objemail = new SimpleEmail();
//        objemail.setFrom("dednasir@yahoo.com ");
//        objemail.addTo("recipient@zenexity.fr");
//        objemail.setSubject("subject");
//        objemail.setMsg("Message");
//        Mail.send(email); 
        render();
    }
    
    public static void logout() {
        session.clear();
        index();
    }
    
    public static void index() {
        render();
    }

    public static void faq() {
        render();
    }
    
    public static void shoppingcart() {
        render();
    }
    
    public static void about() {
        render();
    }
    
    public static void soups() {
        render();
    }
    
    public static void login() {
        render();
    }
    
    public static void blog() {
        render();
    }
    
    public static void contact() {
        render();
    }
    
    public static void blogpost() {
        render();
    }
    
    public static void myaccount() {
        render();
    }
    
    public static void soupsgrid() {
        render();
    }
    
    public static void gallery() {
        render();
    }
    
    public static void orderhistory() {
        render();
    }
    
    public static void lostPassword() {
        render();
    }
    
    public static void register(){
        render();
    }
}