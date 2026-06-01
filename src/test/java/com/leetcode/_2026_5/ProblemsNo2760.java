package com.leetcode._2026_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2760. 最长奇偶子数组
 *
 * @author DHW
 * @date 2026/5/20 11: 03
 * @Version 1.0
 */
public class ProblemsNo2760 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,54,4,7};
        System.out.println("res = " + longestAlternatingSubarray(nums, 2));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0 && nums[i] <= threshold) {
                int r = i + 1;
                while(r < n && nums[r] % 2 != nums[r-1] % 2 && nums[r] <= threshold) {
                    r++;
                }
                ans = Math.max(ans, r - i);
                i = r - 1;
            }
        }
        return ans;
    }

}

