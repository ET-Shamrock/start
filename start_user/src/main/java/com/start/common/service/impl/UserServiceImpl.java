package com.start.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.start.common.mapper.UserInfoMapper;
import com.start.common.mapper.UserMapper;
import com.start.common.pojo.User;
import com.start.common.pojo.UserInfo;
import com.start.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    // 从spring容器中取数据访问层的对象
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<User> queryAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    public User queryUserByEmail(String user_email) {
        User user = userMapper.selectByEmail(user_email);
        return user;
    }
    public UserInfo queryUserInfo(String user_id) {
        UserInfo res = userInfoMapper.selectByID(user_id);
        return res;
    }
}
