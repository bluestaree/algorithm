package com.leetcode._2026_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3880. 两个值之间的最小绝对差值
 *
 * @author DHW
 * @date 2026/9/22 8:40
 * @Version 1.0
*/
public class ProblemsNo3880 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1};
        System.out.println("res = " + minAbsoluteDifference(nums));
    }

    public int minAbsoluteDifference(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] arr = new int[]{0, -n, -n};
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                if(nums[i] == 1) {
                    arr[1] = i;
                }
                if(nums[i] == 2) {
                    arr[2] = i;
                }
                if(arr[1] >= 0 && arr[2] >= 0) {
                    ans = Math.min(ans, Math.abs(arr[1] - arr[2]));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

