package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3106. 满足距离约束且字典序最小的字符串
 *
 * @author DHW
 * @date 2024/7/27 11:23
 * @Version 1.0
*/
public class ProblemsNo3106 {

    @Test
    public void solution() {
        String s = "zbbz";
        int k = 3;
        System.out.println("res = " + getSmallestString(s, k));
    }

    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = Math.min(chars[i] - 'a', 'z' - chars[i] + 1);
            if(n > k) {
                chars[i] -= k;
                break;
            }
            chars[i] = 'a';
            k -= n;
        }
        return new String(chars);
    }
}

