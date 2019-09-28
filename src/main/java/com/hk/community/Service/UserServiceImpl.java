package com.hk.community.Service;

import com.hk.community.dao.UserDao;
import com.hk.community.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * created by hk on 2019/9/28 23:48
 */
@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> getUserInfoByUsername(String username) {
        return this.userDao.selUserByUsername(username);
    }

    @Override
    public UserDto getUserInfoByUserId(int userId) {
        return this.userDao.selUserByUserId(userId);
    }
}
