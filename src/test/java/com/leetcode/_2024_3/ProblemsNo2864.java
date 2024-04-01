package com.leetcode._2024_3;

import org.junit.Test;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 * 2864. 最大二进制奇数
 *
 * @author DHW
 * @date 2024/3/13 9:21
 * @Version 1.0
*/
public class ProblemsNo2864 {

    @Test
    public void solution() {
        String s = "0010101";
        System.out.println("res = " + maximumOddBinaryNumber(s));
    }

    public String maximumOddBinaryNumber(String s) {
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '1') {
                num++;
            }
        }
        if(num == len) {
            return s;
        }
        char[] chars = new char[len];
        Arrays.fill(chars, '0');
        for (int i = 0; i < num - 1; i++) {
            chars[i] = '1';
        }
        chars[len-1] = '1';
        return new String(chars);
    }

}

