package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2496. 数组中字符串的最大值
 *
 * @author DHW
 * @date 2023/6/23 11:17
 * @Version 1.0
*/
public class ProblemsNo2496 {

    @Test
    public void solution() {
        String[] strs = new String[]{"alic3","bob","3","4","00000"};

        System.out.println("res = " + maximumValue(strs));
    }

    public int maximumValue(String[] strs) {
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            int len = isNums(strs[i]);
            if(len == -1) {
                len = strs[i].length();
            }
            max = Math.max(max, len);
        }
        return max;
    }

    private int isNums(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!Character.isDigit(chars[i])) {
                return -1;
            }
        }
        return Integer.parseInt(s);
    }
}
