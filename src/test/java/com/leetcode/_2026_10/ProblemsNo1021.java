package com.leetcode._2026_10;

import org.junit.Test;


/**
 * 1021. 删除最外层的括号
 *
 * @author DHW
 * @date 2026/10/8 9: 05
 * @Version 1.0
 */
public class ProblemsNo1021 {

    @Test
    public void solution() {
        String s = "(()())(())";
        System.out.println("= res = " + removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String S) {
        char[] s = S.toCharArray();
        int size = 0;
        int deep = 0;
        for (char c : s) {
            if (c == '(') {
                if(deep > 0) {
                    s[size++] = c;
                }
                deep++;
            } else {
                deep--;
                 if(deep > 0) {
                     s[size++] = c;
                 }
            }
        }
        return new String(s, 0, size);
    }
}

