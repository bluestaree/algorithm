package com.leetcode._2025_6;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2434. 使用机器人打印字典序最小的字符串
 *
 * @author DHW
 * @date 2025/6/6 8: 47
 * @Version 1.0
*/
public class ProblemsNo2434 {

    @Test
    public void solution() {
        String s = "bdda";
        System.out.println("res = " + robotWithString(s));
    }

    public String robotWithString(String s) {
        int n = s.length();
        // 计算后缀最小值
        char[] sufMin = new char[n + 1];
        sufMin[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sufMin[i] = (char) Math.min(sufMin[i + 1], s.charAt(i));
        }

        StringBuilder ans = new StringBuilder(n);
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st.push(s.charAt(i));
            while (!st.isEmpty() && st.peek() <= sufMin[i + 1]) {
                ans.append(st.pop());
            }
        }
        return ans.toString();
    }
}

