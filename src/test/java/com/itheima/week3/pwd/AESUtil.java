package com.itheima.week3.pwd;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESUtil {
    private static final String IV_STRING = "sdf4ddfsFD86Vdf2";
    private static final String encoding = "UTF-8";
    
    public static String encryptAES(String content, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(encoding), "AES");
        byte[] initParam = IV_STRING.getBytes(encoding);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        // 指定加密的算法、工作模式和填充方式
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(content.getBytes(encoding));
        // 同样对加密后数据进行 base64 编码
        String base64 = new Base64().encodeToString(encryptedBytes);
        return URLEncoder.encode(base64, encoding);
    }
    
    public static String decryptAES(String content, String key)
            throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, IOException {
        //URL解码
        content = URLDecoder.decode(content, encoding);
        // base64 解码
        byte[] encryptedBytes = Base64.decodeBase64(content);
        byte[] enCodeFormat = key.getBytes(encoding);
        SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = IV_STRING.getBytes(encoding);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] result = cipher.doFinal(encryptedBytes);
        return new String(result, encoding);
    }
    
    public static void main(String[] args) throws Exception {
    /*json.put("name", "张三");
    json.put("cityCode", "100001");
    json.put("cityName", "北京市");
    json.put("mobileNo", "15651876590");*/
        String content = "架构师训练营";
        System.out.println("加密前：" + content);
        String key = "djadiKJdj49dFJLd";
        System.out.println("密钥：" + key);
        String encrypt = encryptAES(content, key);
        System.out.println("加密后：" + encrypt);
        String decrypt = decryptAES(encrypt, key);
        System.out.println("解密后：" + decrypt);
    }
}
