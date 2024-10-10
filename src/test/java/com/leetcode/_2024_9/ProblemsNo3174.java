package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 3174. 清除数字
 *
 * @author DHW
 * @date 2024/9/5 9:1
 * @Version 1.0
*/
public class ProblemsNo3174 {

    @Test
    public void solution() {
        String s = "cb34";
        System.out.println("res = " + clearDigits(s));
    }

    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

