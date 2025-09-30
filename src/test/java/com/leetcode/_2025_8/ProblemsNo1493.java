package com.leetcode._2025_8;

import org.junit.Test;


/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * @author DHW
 * @date 2025/8/24 9: 38
 * @Version 1.0
*/
public class ProblemsNo1493 {

    @Test
    public void solution() {
        int[] nums =  new int[]{2,5};
        System.out.println("res = " + longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int left = 0;
        int cnt0 = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right];
            while( cnt0 > 1) {
                cnt0 -= 1 -nums[left];
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}

