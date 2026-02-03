package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 209. 长度最小的子数组
 *
 * @author DHW
 * @date 2026/1/13 9: 13
 * @Version 1.0
*/
public class ProblemsNo209 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6,1,2};
        int target = 2;
        System.out.println("res = " + minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = ans == 0 ? right - left + 1 : Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }

}

