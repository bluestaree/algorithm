package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 713. 乘积小于 K 的子数组
 *
 * @author DHW
 * @date 2026/1/15 14: 11
 * @Version 1.0
*/
public class ProblemsNo713 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3};
        int k = 1;
        System.out.println("res = " + numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int ans = 0;
        int left = 0;
        int num = 1;
        for (int r = 0; r < nums.length; r++) {
            num *= nums[r];
            while (num >= k) {
                num /= nums[left];
                left++;
            }
            ans += r - left + 1;
        }
        return ans;
    }
}

