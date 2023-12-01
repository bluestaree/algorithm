package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 2609. 最长平衡子字符串
 *
 * @author DHW
 * @date 2023/11/8 11:40
 * @Version 1.0
 */
public class ProblemsNo2609 {

    @Test
    public void solution() {
        String s = "01000111";
        System.out.println("minimum = " + findTheLongestBalancedSubstring(s));
    }

    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int a = 0;
        int b = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '0') {
                if(b != 0) {
                    res = Math.max(res, Math.min(a, b) << 1);
                    b = 0;
                    a = 1;
                    continue;
                }
                a++;
            } else {
                b++;
            }
        }
        return Math.max(res, Math.min(a, b) << 1);
    }
}