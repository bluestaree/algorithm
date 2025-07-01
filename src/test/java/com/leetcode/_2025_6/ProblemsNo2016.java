package com.leetcode._2025_6;

import org.junit.Test;

import java.lang.reflect.Array;


/**
 * 2016. 增量元素之间的最大差值
 *
 * @author DHW
 * @date 2025/6/16 8: 39
 * @Version 1.0
*/
public class ProblemsNo2016 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,1,5,4};
        System.out.println("res = " + maximumDifference(nums));
    }

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int preMin = nums[0];
        int res = -1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > preMin) {
                res = Math.max(res, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return res;
    }
}

