package springbook.user.service;

import springbook.user.dao.UserDao;

/**
 * Created by dw on 2016. 1. 23..
 */
public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
