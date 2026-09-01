package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 1283. 使结果不超过阈值的最小除数
 *
 * @author DHW
 * @date 2026/8/6 8: 55
 * @Version 1.0
 */
public class ProblemsNo1283 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,5,2,1};
        int threshold = 6;
        System.out.println("= res = " + smallestDivisor(nums, threshold));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkDivisor(nums, mid, threshold)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkDivisor(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / mid + 1;
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}

