package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2696. 删除子串后的字符串最小长度
 *
 * @author DHW
 * @date 2024/1/10 8:49
 * @Version 1.0
*/
public class ProblemsNo2696 {

    @Test
    public void solution() {
        String s = "D";
        System.out.println("res = " + minLength(s));
    }

    public int minLength(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(!deque.isEmpty() && ((s.charAt(i) == 'B' && deque.peek() == 'A') || (s.charAt(i) == 'D' && deque.peek() == 'C'))) {
                deque.pop();
                continue;
            }
            deque.push(s.charAt(i));
        }
        return deque.size();
    }
}

