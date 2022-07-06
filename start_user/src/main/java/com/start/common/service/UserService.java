package com.start.common.service;

import com.start.common.pojo.User;
import com.start.common.pojo.UserInfo;


import java.util.List;
import java.util.Map;

// 用户服务层
public interface UserService {

    public List<User> queryAll();
    public User queryUserByEmail(String user_email);

    public UserInfo queryUserInfo(String user_id);
}
