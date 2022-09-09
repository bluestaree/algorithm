package com.itheima.week3.pwd;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static void main(String[] args) throws Exception {
        //生成KEY
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128);
        //key转换         
        SecretKeySpec key = new SecretKeySpec(aes.generateKey().getEncoded(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        
        String src = "我是架构师了吗";
        System.out.println("明文：" + src);
        
        //加密
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(src.getBytes());
        
        System.out.println("加密：" + Base64.encodeBase64String(result));
        
        //解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        result = cipher.doFinal(result);
        System.out.println("解密：" + new String(result));
    }
}
