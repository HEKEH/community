package com.hk.community.Service;

import com.hk.community.model.UserDto;

import java.util.List;

/**
 * created by hk on 2019/9/28 23:41
 */
public interface UserService {
    public List<UserDto> getUserInfoByUsername(String username);
    public UserDto getUserInfoByUserId(int userId);
}
