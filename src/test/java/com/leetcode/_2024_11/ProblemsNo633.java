package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 633. 平方数之和
 *
 * @author DHW
 * @date 2024/11/4 8: 35
 * @Version 1.0
*/
public class ProblemsNo633 {

    @Test
    public void solution() {
        int c = 15;
        System.out.println("res = " + judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while(l <= r) {
            long val = (long) l * l + (long) r * r;
            if(val == c) {
                return true;
            }
            if(val < c) {
                l++;
            } else {
                r--;
            }

        }
        return false;
    }
}

