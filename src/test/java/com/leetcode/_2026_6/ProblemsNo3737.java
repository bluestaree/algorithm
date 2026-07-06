package com.leetcode._2026_6;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 3737. 统计主要元素子数组数目 I
 *
 * @author DHW
 * @date 2026/6/25 8: 51
 * @Version 1.0
 */
public class ProblemsNo3737 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,2,1};
        int target = 2;
        System.out.println("= res = " + countMajoritySubarrays(nums, target));
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) cnt++;
                if (cnt * 2 > j - i + 1) ans++;
            }
        }
        return ans;
    }
}

