package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1838. 最高频元素的频数
 *
 * @author DHW
 * @date 2026/1/9 9: 35
 * @Version 1.0
*/
public class ProblemsNo1838 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,9,6};
        int k = 2;
        System.out.println("res = " + maxFrequency(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while ((long) (r - l + 1) * nums[r] - sum > k) {
                sum -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

