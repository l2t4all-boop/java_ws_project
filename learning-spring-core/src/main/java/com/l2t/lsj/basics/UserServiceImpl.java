package com.l2t.lsj.basics;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl() ;

    @Override
    public List<String> getUsers() {
        return userDao.selectUsers();
    }
}
