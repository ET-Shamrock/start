package com.start.common.service;

import com.start.common.pojo.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface AuthService {
    public String VerifyPassword(User user, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    public Object queryInfoByToken(String Token);
}
