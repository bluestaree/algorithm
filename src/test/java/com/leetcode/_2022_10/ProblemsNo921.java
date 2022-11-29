package com.leetcode._2022_10;

import org.junit.Test;

import java.util.Stack;


/**
 * 924. 使括号有效的最少添加
 *
 * @author DHW
 * @date 2022/10/4 11:36
 * @Version 1.0
*/
public class ProblemsNo921 {

    @Test
    public void solution() {
        String s = "())()((";
        System.out.println("s = " + minAddToMakeValid(s));
    }

    public int minAddToMakeValid(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar == '(') {
                left++;
            } else {
                if(left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return right + left;
    }

    public int minAddToMakeValid1(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int result = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int size = stack.size();
            if(size == 0) {
                if(chars[i] == '(') {
                    stack.push(chars[i]);
                }else {
                    result++;
                }
                continue;
            }
            if(chars[i] == ')') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return result + stack.size();
    }
}
