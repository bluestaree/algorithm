package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3083. 字符串及其反转中是否存在同一子字符串
 *
 * @author DHW
 * @date 2024/12/26 8: 36
 * @Version 1.0
*/
public class ProblemsNo3083 {

    @Test
    public void solution() {
        String s = "leetcode";
        System.out.println("res = " + isSubstringPresent(s));
    }

    public boolean isSubstringPresent(String s) {
        boolean[][] d = new boolean[26][26];
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            d[array[i-1] - 'a'][array[i] - 'a'] = true;
        }
        for (int i = 1; i < array.length; i++) {
            if(d[array[i] - 'a'][array[i-1] - 'a']) {
                return true;
            }
        }
        return false;
    }
}

