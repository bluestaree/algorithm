package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3723. 数位平方和的最大值
 *
 * @author DHW
 * @date 2026/10/14 8:33
 * @Version 1.0
*/
public class ProblemsNo3723 {

    @Test
    public void solution() {
        int num = 2;
        int sum = 17;
        System.out.println("res = " + maxSumOfSquares(num, sum));
    }

    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        while (num > 0 && sum > 0) {
            int x = Math.min(9, sum);
            ans.append(x);
            sum -= x;
            num--;
        }
        if (sum != 0) {
            return "";
        }
        while (num > 0) {
            ans.append("0");
            num--;
        }
        return ans.toString();
    }
}

