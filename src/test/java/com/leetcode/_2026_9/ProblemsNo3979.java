package com.leetcode._2026_9;

import org.junit.Test;


/**
 * 3979. 最大有效数对和
 *
 * @author DHW
 * @date 2026/9/28 9:24
 * @Version 1.0
*/
public class ProblemsNo3979 {

    @Test
    public void solution() {
        int[] nums = new int[]{93,93};
        int k = 1;
        System.out.println("res = " + maxValidPairSum(nums, k));
    }

    public int maxValidPairSum(int[] nums, int k) {
        int ans = 0;
        int mx = 0;
        for (int j = k; j < nums.length; j++) {
            mx = Math.max(mx, nums[j - k]);
            ans = Math.max(ans, mx + nums[j]);
        }
        return ans;

    }
}

