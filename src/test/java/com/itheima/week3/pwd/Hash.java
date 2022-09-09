package com.itheima.week3.pwd;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {
    
    /**
     * jdk的security实现md5
     * 也可以借助commons-codec包
     */
    public static String md5(String src) {
        byte[] pwd = null;
        try {
            pwd = MessageDigest.getInstance("md5").digest(src.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String code = new BigInteger(1, pwd).toString(16);
        for (int i = 0; i < 32 - code.length(); i++) {
            code = "0" + code;
        }
        return code;
    }
    
    public static String commonsMd5(String src) {
        return DigestUtils.md5Hex(src);
    }
    
    /**
     * jdk实现sha算法
     * 也可以借助commons-codec包
     */
    public static String sha(String src) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("sha");
        byte[] shaByte = sha.digest(src.getBytes("utf-8"));
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < shaByte.length; i++) {
            int val = ((int) shaByte[i]) & 0xff;
            if (val < 16) {
                code.append("0");
            }
            code.append(Integer.toHexString(val));
        }
        return code.toString();
    }
    
    public static String commonsSha(String src) throws Exception {
        return DigestUtils.sha1Hex(src);
    }
    
    public static void main(String[] args) throws Exception {
        String name = "我是大神";
        System.out.println(name);
        System.out.println(md5(name));
        System.out.println(commonsMd5(name));
        System.out.println(sha(name));
        System.out.println(commonsSha(name));
    }
}
