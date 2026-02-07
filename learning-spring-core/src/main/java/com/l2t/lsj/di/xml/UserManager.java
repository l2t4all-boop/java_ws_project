package com.l2t.lsj.di.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getUsers());

    }
}
