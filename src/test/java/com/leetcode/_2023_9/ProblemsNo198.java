package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 198. 打家劫舍
 *
 * @author DHW
 * @date 2023/9/16 11:04
 * @Version 1.0
*/
public class ProblemsNo198 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,1};
        System.out.println("res = " + rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i-1], f[i - 2] + nums[i - 1]);
        }
        return f[n];
    }
}
