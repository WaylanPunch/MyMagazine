package com.mymagazine.util;

import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MagazineUtil {

    /**
     * md5加密
     *
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            //String val = Tools.enAes(uid.toString(), WebConst.AES_SALT);
            /*
             *加密
             */
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKeySpec = new SecretKeySpec(MagazineConstant.AES_SALT.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(uid.toString().getBytes());
            String val = new BASE64Encoder().encode(encryptedBytes);

            /*
             *返回存储
             */
            boolean isSSL = false;
            Cookie cookie = new Cookie(MagazineConstant.LOGIN_COOKIE_KEY, val);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
