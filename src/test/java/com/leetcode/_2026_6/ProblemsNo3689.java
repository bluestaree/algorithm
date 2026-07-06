package com.leetcode._2026_6;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 3689. 最大子数组总值 I
 *
 * @author DHW
 * @date 2026/6/9 8: 36
 * @Version 1.0
 */
public class ProblemsNo3689 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,2,1};
        int k = 2;
        System.out.println("= res = " + maxTotalValue(nums, k));
    }

    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return (long)(max - min) * k;
    }
}

