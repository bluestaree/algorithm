package com.leetcode._2025_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2210. 统计数组中峰和谷的数量
 *
 * @author DHW
 * @date 2025/7/27 10: 17
 * @Version 1.0
*/
public class ProblemsNo2210 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,7,9};
        System.out.println("res = " + countHillValley(nums));
    }

    public int countHillValley(int[] nums) {
        int ans = 0;
        int l = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }

            if(nums[i] > l && nums[i] > nums[i+1]) {
                ans++;
            } else if (nums[i] < l && nums[i] < nums[i+1]) {
                ans++;
            }
            l = nums[i];
        }
        return ans;
    }
}

