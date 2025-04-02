package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


/**
 * 1963. 使字符串平衡的最小交换次数
 *
 * @author DHW
 * @date 2025/3/17 9: 09
 * @Version 1.0
*/
public class ProblemsNo1963 {

    @Test
    public void solution() {
        String s = "][][";
        System.out.println("res = " + minSwaps(s));
    }

    public int minSwaps(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '[') {
                stack.push(c);
            } else if(!stack.isEmpty()) {
                stack.pop();
            }
        }
        return (stack.size() + 1) / 2;
    }
}

