package com.leetcode._2024_10;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;


/**
 * 3192. 使二进制数组全部等于 1 的最少操作次数 II
 *
 * @author DHW
 * @date 2024/10/19 10: 08
 * @Version 1.0
*/
public class ProblemsNo3192 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        System.out.println("res = " + minOperations(nums));
    }

    public int minOperations(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (x == k % 2) {
                k++;
            }
        }
        return k;
    }
}

