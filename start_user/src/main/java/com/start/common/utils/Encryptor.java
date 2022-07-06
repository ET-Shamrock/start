package com.start.common.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 处理数据加密
public class Encryptor {
    public static String SHA1(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(str.getBytes("utf8"));
        return String.format("%040x", new BigInteger(1, digest.digest()));
    }

    public static String MD5(String str) {
        String md5Str = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5Str;
    }
}
