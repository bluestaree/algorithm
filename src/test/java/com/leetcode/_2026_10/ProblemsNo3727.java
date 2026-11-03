package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3727. 最大交替平方和
 *
 * @author DHW
 * @date 2026/10/13 9:37
 * @Version 1.0
*/
public class ProblemsNo3727 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        System.out.println("res = " + maxAlternatingSum(nums));
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long ans = 0;
        int m = nums.length / 2;

        for (int i = 0; i < m; i++) {
            ans -= nums[i];
        }
        for (int i = m; i < n; i++) {
            ans += nums[i];
        }
        return ans;
    }
}

