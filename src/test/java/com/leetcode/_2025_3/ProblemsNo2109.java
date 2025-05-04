package com.leetcode._2025_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2109. 向字符串添加空格
 *
 * @author DHW
 * @date 2025/3/30 10: 52
 * @Version 1.0
*/
public class ProblemsNo2109 {

    @Test
    public void solution() {
        String s = "spacing";
        int[] spaces = new int[]{0,1,2,3,4,5,6};
        System.out.println("res = " + addSpaces(s, spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        char[] chars = new char[n + m];
        for (int i = 0,j = 0, k = 0; i <  chars.length; i++) {
            if(j < m && (k == spaces[j])) {
                chars[i] = ' ';
                j++;
                continue;
            }
            chars[i] = s.charAt(k++);
        }
        return new String(chars);
    }
}

