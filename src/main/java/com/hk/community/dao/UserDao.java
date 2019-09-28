package com.hk.community.dao;

import com.hk.community.model.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by hk on 2019/9/28 23:29
 */
@Repository
public interface UserDao {
    public UserDto selUserByUserId(int userId);
    public List<UserDto> selUserByUsername(String username);
}
