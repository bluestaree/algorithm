package com.leetcode._2022_11;

import org.junit.Test;


/**
 * 1704. 判断字符串的两半是否相似
 *
 * @author DHW
 * @date 2022/11/11 10:39
 * @Version 1.0
*/
public class ProblemsNo1704 {

    @Test
    public void solution() {
        String s = "book";
        System.out.println("s = " + halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < chars.length / 2; i++) {
            a  += checknum(chars[i]);
        }

        for (int i = chars.length / 2; i < chars.length; i++) {
            b += checknum(chars[i]);
        }
        return a == b;
    }

    private int checknum(char aChar) {
        switch (aChar) {
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return 1;
            default:
                break;
        }
        return 0;
    }

}
