package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2712. 使所有字符相等的最小成本
 *
 * @author DHW
 * @date 2025/3/27 9: 37
 * @Version 1.0
*/
public class ProblemsNo2712 {

    @Test
    public void solution() {
        String s = "110101";
        System.out.println("res = " + minimumCost(s));
    }

    public long minimumCost(String s) {
        long  res = 0;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                res += Math.min(i, length - i);
            }
        }
        return res;
    }
}

