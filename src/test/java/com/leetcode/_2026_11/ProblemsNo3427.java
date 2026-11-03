package com.leetcode._2026_11;

import org.junit.Test;


/**
 * 3427. 变长子数组求和
 *
 * @author DHW
 * @date 2026/11/2 8:34
 * @Version 1.0
*/
public class ProblemsNo3427 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        System.out.println("res = " + subarraySum(nums));
    }

    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            sum[i + 1] = sum[i] + nums[i];
            ans += sum[i + 1] - sum[Math.max(0, i - nums[i])];
        }
        return ans;
    }
}

