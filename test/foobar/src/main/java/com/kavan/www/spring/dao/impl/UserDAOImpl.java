package com.kavan.www.spring.dao.impl;

import com.kavan.www.spring.dao.UserDAO;
import com.kavan.www.spring.model.User;

/**
 * Created by Ritchie in 19:19 2018/1/11.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println("user saved!");
    }
}
