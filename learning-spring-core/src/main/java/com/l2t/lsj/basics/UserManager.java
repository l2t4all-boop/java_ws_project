package com.l2t.lsj.basics;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        List<String> users =  userService.getUsers();
        users.forEach(name->{
            System.out.println(name.toUpperCase());
        });
    }
}
