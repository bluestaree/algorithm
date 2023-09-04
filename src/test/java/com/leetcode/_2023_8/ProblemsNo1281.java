package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 1281. 整数的各位积和之差
 *
 * @author DHW
 * @date 2023/8/9 8:47
 * @Version 1.0
*/
public class ProblemsNo1281 {

    @Test
    public void solution() {
        int nums = 4421;
        System.out.println("res = " + subtractProductAndSum(nums));
    }

    public int subtractProductAndSum(int n) {
        int sum = 0, multiply = 1;
        while(n != 0) {
            int cur = n % 10;
            sum += cur;
            multiply *= cur;
            n /= 10;
        }
        return multiply - sum;
    }
}
