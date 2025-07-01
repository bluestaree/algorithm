package com.leetcode._2025_6;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3423. 循环数组中相邻元素的最大差值
 *
 * @author DHW
 * @date 2025/6/12 8: 29
 * @Version 1.0
*/
public class ProblemsNo3423 {

    @Test
    public void solution() {
        int[] nums = new int[]{-2,1,-5};
        System.out.println("res = " + maxAdjacentDistance(nums));
    }

    public int maxAdjacentDistance(int[] nums) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res = Math.max(res, Math.abs(nums[i-1] - nums[i % nums.length]));
        }
        return res;
    }
}

