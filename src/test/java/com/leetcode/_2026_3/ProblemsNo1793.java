package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1793. 好子数组的最大分数
 *
 * @author DHW
 * @date 2026/3/26 9: 13
 * @Version 1.0
 */
public class ProblemsNo1793 {

    @Test
    public void solution() {
        int[] nums = new int[]{8,7,1};
        int k = 11;
        System.out.println("res = " + maximumScore(nums, k));
    }

    public int maximumScore(int[] nums, int k) {
        int ans = 0;
        int l = k, r = k;
        int min = nums[k];
        for(; l >= 0 && r < nums.length; ) {
            min = Math.min(min, Math.min(nums[l], nums[r]));
            ans = Math.max(ans, min * (r - l + 1));
            if (l == 0) {
                r++;
            } else if (r == nums.length - 1) {
                l--;
            } else if (nums[l - 1] > nums[r + 1]) {
                l--;
            } else {
                r++;
            }
        }
        return ans;
    }

}

