package com.example.blog.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    /**
     * @param text 明文
     * @param key  密钥
     * @return     密文
     */

    //带密钥加密
    public static String md5WithKey(String text, String key) throws Exception{
        //加密后的字符串
        String keyAndValue = text + key;
        String md5str = DigestUtils.md5DigestAsHex(keyAndValue.getBytes());
        System.out.println("md5加密后的字符串为"+md5str);
        return md5str;
    }

    //不带密钥加密
    public static String md5NotKey(String text)throws Exception{
        String md5str = DigestUtils.md5DigestAsHex(text.getBytes());
        System.out.println("md5加密后的字符串为"+md5str);
        return md5str;
    }
    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     */
    //根据传入的密钥进行验证
    public static boolean verify(String text, String key, String md5)throws Exception{
        String md5str = md5WithKey(text,key);
        if(md5str.equalsIgnoreCase(md5)){
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

   /* public static void main(String[] args) throws Exception {
        System.out.println("加密后"+md5NotKey("123789"));
    }*/
}
