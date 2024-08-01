package com.leetcode._2024_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2740. 找出分区值
 *
 * @author DHW
 * @date 2024/7/26 10:38
 * @Version 1.0
*/
public class ProblemsNo2740 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + findValueOfPartition(nums));
    }

    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, nums[i] - nums[i-1]);
        }
        return res;
    }
}

