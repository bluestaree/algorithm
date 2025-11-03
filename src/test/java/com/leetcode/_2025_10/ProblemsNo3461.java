package com.leetcode._2025_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


/**
 * 3461. 判断操作后字符串中的数字是否相等 I
 *
 * @author DHW
 * @date 2025/10/23 8: 39
 * @Version 1.0
*/
public class ProblemsNo3461 {

    @Test
    public void solution() {
        String s = "3902";
        System.out.println("res = " + hasSameDigits(s));
    }

    public boolean hasSameDigits(String s) {
        int n = s.length();
        char[] t = s.toCharArray();
        for (int i = n - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                t[j] = (char) ((t[j] - '0' + t[j + 1] - '0') % 10 + '0');
            }
        }
        return t[0] == t[1];
    }
}

