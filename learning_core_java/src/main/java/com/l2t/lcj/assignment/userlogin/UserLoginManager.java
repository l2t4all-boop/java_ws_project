package com.l2t.lcj.assignment.userlogin;

public class UserLoginManager {

    public static void main(String[] args) {

        UserLoginService userLoginService = null;

        String username1 = userLoginService.login("user1","pass1");
        System.out.println("User name :"+username1);
        String username2 = userLoginService.login("absc","aksdjfr");
        System.out.println("User name :"+username2);
    }
}
