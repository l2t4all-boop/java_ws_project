package com.l2t.lsj.di.xml;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<String> selectUsers() {
        return List.of("Krish","Manoj","Charan","Jayesh");
    }
}
