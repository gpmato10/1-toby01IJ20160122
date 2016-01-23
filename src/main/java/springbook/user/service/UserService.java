package springbook.user.service;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

/**
 * Created by dw on 2016. 1. 23..
 */
public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for (User user : users) {
            Boolean changed = null;

            if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) { // BASIC -> SILVER 업그레이드
                user.setLevel(Level.SILVER);
                changed = true;
            } else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
                user.setLevel(Level.GOLD);
                changed = true; // SILVER -> GOLD 업그레이드
            } else if (user.getLevel() == Level.GOLD) {
                changed = false;    // 레벨 변경이 없음.
            }
            else  {
                changed = false;
            }
            if (changed) {
                userDao.update(user);   // 레벨변경이 있는 경우에만 update() 호출
            }
        }
    }
}
