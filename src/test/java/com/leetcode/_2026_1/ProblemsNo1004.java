package com.leetcode._2026_1;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1004. 最大连续1的个数 III
 *
 * @author DHW
 * @date 2026/1/5 9: 08
 * @Version 1.0
*/
public class ProblemsNo1004 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("res = " + longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                k--;
                while(k < 0) {
                    if (nums[l] == 0) {
                        k++;
                    }
                    l++;
                }
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}

