package com.leetcode._2026_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2576. 求出最多标记下标
 *
 * @author DHW
 * @date 2026/8/28 8: 55
 * @Version 1.0
 */
public class ProblemsNo2576 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,2,3,1};
        System.out.println("= res = " + maxNumOfMarkedIndices(nums));
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, nums)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right * 2;
    }

    private boolean check(int mid, int[] nums) {
        for (int i = 0; i < mid; i++) {
            if (nums[i] * 2 > nums[nums.length - mid + i]) {
                return false;
            }
        }
        return true;
    }
}

