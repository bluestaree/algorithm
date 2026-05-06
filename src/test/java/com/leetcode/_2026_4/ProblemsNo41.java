package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 41. 缺失的第一个正数
 *
 * @author DHW
 * @date 2026/4/1 10: 49
 * @Version 1.0
 */
public class ProblemsNo41 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,0};
        System.out.println("sortArrayByParity(nums) = " + firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                continue;
            }
            int idx = nums[i] - 1;
            while (idx >= 0 && idx < n) {
                int temp = nums[idx];
                nums[idx] = -1;
                idx = temp - 1;
            }
        }
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            if(nums[i] >= 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}

