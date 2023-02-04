package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2299. 强密码检验器 II
 *
 * @author DHW
 * @date 2023/1/19 12:20
 * @Version 1.0
*/
public class ProblemsNo2299 {

    @Test
    public void solution() {
        String password = "IloveLe3tcode!";
        System.out.println("res = " + strongPasswordCheckerII(password));
    }

    public boolean strongPasswordCheckerII(String password) {
        char[] chars = password.toCharArray();
        if(chars.length < 8) {
            return false;
        }
        String special = "!@#$%^&*()-+";
        boolean includeLowercase = false;
        boolean includeUppercase = false;
        boolean includeDigit = false;
        boolean includeSpecial = false;
        Character pre = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if(i != 0 && chars[i] == pre) {
                return false;
            }
            pre = chars[i];
            if(Character.isLowerCase(chars[i])) {
                includeLowercase = true;
                continue;
            }
            if(Character.isUpperCase(chars[i])) {
                includeUppercase = true;
                continue;
            }
            if(Character.isDigit(chars[i])) {
                includeDigit = true;
                continue;
            }
            if(special.indexOf(chars[i]) >= 0) {
                includeSpecial = true;
                continue;
            }
        }
        return includeLowercase && includeUppercase && includeDigit && includeSpecial;
    }
}
