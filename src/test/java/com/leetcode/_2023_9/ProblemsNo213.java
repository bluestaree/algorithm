package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 213. 打家劫舍II
 *
 * @author DHW
 * @date 2023/9/17 13:01
 * @Version 1.0
*/
public class ProblemsNo213 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,1};
        System.out.println("res = " + rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1)) ;
    }

    public int rob(int[] nums, int l, int r) {
        int a = 0,b = 0;
        for (int i = l; i <= r; i++) {
            int max = Math.max(a,b);
            a = b + nums[i];
            b = max;
        }
        return Math.max(a,b);
    }
}

