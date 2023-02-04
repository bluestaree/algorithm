package com.leetcode._2023_1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2309. 兼具大小写的最好英文字母
 *
 * @author DHW
 * @date 2023/1/27 17:27
 * @Version 1.0
*/
public class ProblemsNo2309 {

    @Test
    public void solution() {
        String s = "lEeTcOdE";
        System.out.println("res = " + greatestLetter(s));
    }

    public String greatestLetter(String s) {
        Set<Character> ht = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ht.add(c);
        }
        for (int i = 25; i >= 0; i--) {
            if (ht.contains((char) ('a' + i)) && ht.contains((char) ('A' + i))) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}