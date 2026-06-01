package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 674. 最长连续递增序列
 *
 * @author DHW
 * @date 2026/5/8 9: 46
 * @Version 1.0
 */
public class ProblemsNo674 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1,3,5,4,7};
        findLengthOfLCIS(nums1);
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                len++;
            } else {
                len = 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

}

