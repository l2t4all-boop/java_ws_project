package com.l2t.lcj.collections;

import java.util.HashSet;
import java.util.Set;

public class UserRegistration {

    private Set<String> emails = new HashSet<>();

    public void register(String email){
        if(emails.add(email)){
            System.out.println("User registered with email :"+email);
        }else{
            System.out.println("Email "+email+" already registred");
        }
    }

    public void showRegisteredEmails(){
        System.out.println("Total :"+emails.size());
        emails
                .forEach(System.out::println);
    }


    public static void main(String[] args) {

        UserRegistration userRegistration = new UserRegistration();
        userRegistration.register("abc@gmail.com");
        userRegistration.register("lmn@gmail.com");
        userRegistration.register("abc@gmail.com");
        userRegistration.register("xyz@gmail.com");
        userRegistration.register("lmn@gmail.com");

        userRegistration.showRegisteredEmails();


    }

}
