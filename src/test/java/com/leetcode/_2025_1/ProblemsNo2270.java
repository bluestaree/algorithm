package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2270. 分割数组的方案数
 *
 * @author DHW
 * @date 2022/1/13 9: 32
 * @Version 1.0
*/
public class ProblemsNo2270 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + waysToSplitArray(nums));
    }

    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if(s[i] >= s[n] - s[i]) {
                res++;
            }
        }
        return res;
    }
}

