package com.leetcode._2026_10;

import org.junit.Test;

import java.util.HashMap;


/**
 * 2909. 元素和最小的山形三元组 II
 *
 * @author DHW
 * @date 2026/10/28 8:52
 * @Version 1.0
*/
public class ProblemsNo2909 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,0,0};
        System.out.println("res = " + minimumSum(nums));
    }

    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }
        int preMin = nums[0];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if(preMin < nums[i] && nums[i] > suf[i+1]) {
                ans = Math.min(ans, preMin + nums[i] + suf[i+1]);
            }
            preMin = Math.min(preMin, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

