package com.leetcode._2025_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3634. 使数组平衡的最少移除数目
 *
 * @author DHW
 * @date 2025/12/17 8: 52
 * @Version 1.0
*/
public class ProblemsNo3634 {

    @Test
    public void solution() {
        int[] nums =  new int[]{1,34,23};
        int k = 2;
        System.out.println("res = " + minRemoval(nums, k));
    }

    public int minRemoval(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (nums[i] > (long) nums[l] * k) {
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return n - ans;
    }
}

