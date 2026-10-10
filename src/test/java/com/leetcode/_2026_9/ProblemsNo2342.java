package com.leetcode._2026_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2342. 数位和相等数对的最大和
 *
 * @author DHW
 * @date 2026/9/24 8:50
 * @Version 1.0
*/
public class ProblemsNo2342 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,0,1,4};
        System.out.println("res = " + maximumSum(nums));
    }

    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] maxSum = new int[82];
        Arrays.fill(maxSum, Integer.MIN_VALUE);
        for (int num : nums) {
            int sum = 0;
            for (int i = num; i > 0; i /= 10) {
                sum += i % 10;
            }
            ans = Math.max(ans, num + maxSum[sum]);
            maxSum[sum] = Math.max(maxSum[sum], num);
        }
        return ans;
    }
}

