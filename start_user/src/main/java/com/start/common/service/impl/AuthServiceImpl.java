package com.start.common.service.impl;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.start.common.mapper.UserInfoMapper;
import com.start.common.mapper.UserMapper;
import com.start.common.pojo.User;
import com.start.common.pojo.UserInfo;
import com.start.common.pojo.requestResult.JsonData;
import com.start.common.service.AuthService;
import com.start.common.service.UserService;
import com.start.common.utils.Encryptor;
import com.start.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public String VerifyPassword(User user, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(user.getUser_password());

        String s = Encryptor.MD5(password);
        System.out.println("验证用户输入 md5: "+s);
        System.out.println(user.getUser_password());
        if (s.equals(user.getUser_password())) {
            Map<String, String> map = new HashMap<String, String>(){{
                put("user_id", user.getUser_id().toString());
            }};

            String token = JwtUtils.generateToken(map, 7);
            System.out.println("登录生成 token: "+token);
            return token;
        }
        return null;
    }

    @Override
    public Object queryInfoByToken(String token) {
        DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
        Claim user_id = decodedJWT.getClaim("user_id");
        System.out.println(user_id.asString());
        UserInfo res = userInfoMapper.selectByID(user_id.asString());
        return res;
    }
}
