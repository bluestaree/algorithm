package com.leetcode._2026_6;

import org.junit.Test;


/**
 * 3612. 用特殊操作处理字符串 I
 *
 * @author DHW
 * @date 2026/6/16 8: 36
 * @Version 1.0
 */
public class ProblemsNo3612 {

    @Test
    public void solution() {
        String word = "dcacccaa";
        System.out.println("res = " + processStr(word));
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if(s.charAt(i) == '#') {
                sb.append(sb);
            } else if(s.charAt(i) == '%') {
                sb.reverse();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

