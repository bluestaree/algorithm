package com.leetcode._2026_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3255. 长度为 K 的子数组的能量值 II
 *
 * @author DHW
 * @date 2026/6/2 10: 08
 * @Version 1.0
 */
public class ProblemsNo3255 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,1,3};
        int k = 2;
        System.out.println("= res = " + resultsArray(nums, k));
    }

    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}

