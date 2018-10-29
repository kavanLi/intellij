package com.gcbi.damo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.Assert;


public class EncryptionUtils {

    public static String encryption1(String str) {
        Assert.hasText(str, "password must not null！");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static String encryption2(String str) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = str.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);
            // 获得密文  
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char cha[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                cha[k++] = hexDigits[byte0 >>> 4 & 0xf];
                cha[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(cha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
