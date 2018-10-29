package com.kavan.www.spring.service;

import com.kavan.www.spring.dao.UserDAO;
import com.kavan.www.spring.dao.impl.UserDAOImpl;
import com.kavan.www.spring.model.User;

/**
 * Created by Ritchie in 18:53 2018/1/11.
 */
public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public void add(User user) {
        this.userDAO.save(user);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
