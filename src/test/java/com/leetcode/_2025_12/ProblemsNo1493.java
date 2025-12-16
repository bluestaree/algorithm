package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * @author DHW
 * @date 2025/12/16 8: 41
 * @Version 1.0
*/
public class ProblemsNo1493 {

    @Test
    public void solution() {
        int[] nums =  new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println("res = " + longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int ans = 0;
        int l = 0;
        int[] count = new int[2];
        for (int r = 0; r < nums.length; r++) {
            count[nums[r]]++;
            while (count[0] > 1) {
                count[nums[l]]--;
                l++;
            }
            ans = Math.max(ans, count[1]);
        }
        return ans + count[0] - 1;
    }

}

