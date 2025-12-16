package com.leetcode._2025_11;

import org.junit.Test;


/**
 * 643. 子数组最大平均数 I
 *
 * @author DHW
 * @date 2025/11/26 9: 23
 * @Version 1.0
*/
public class ProblemsNo643 {

    @Test
    public void solution() {
        int[] nums =  new int[]{-1};
        int k = 1;
        System.out.println("res = " + maxVowels(nums, k));
    }

    public double maxVowels(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            ans = Math.max(ans, (double)sum / k);
            sum -= nums[l];
        }
        return ans;
    }
}

