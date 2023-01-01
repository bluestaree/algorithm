package com.leetcode._2022_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * 1796. 字符串中第二大的数字
 *
 * @author DHW
 * @date 2022/12/3 9:03
 * @Version 1.0
*/
public class ProblemsNo1796 {

    @Test
    public void solution() {
        String s = "ck077";
        System.out.println("res = " + secondHighest(s));
    }

    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }
}
