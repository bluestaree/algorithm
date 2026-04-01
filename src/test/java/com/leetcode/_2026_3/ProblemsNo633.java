package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 633. 平方数之和
 *
 * @author DHW
 * @date 2026/3/6 10: 07
 * @Version 1.0
*/
public class ProblemsNo633 {

    @Test
    public void solution() {
        int c = 5;
        System.out.println("res = " + judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            if (left * left == c - right * right) {
                return true;
            } else if (left * left < c - right * right) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}

