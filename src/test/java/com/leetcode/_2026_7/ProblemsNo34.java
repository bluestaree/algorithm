package com.leetcode._2026_7;

import org.junit.Test;


/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author DHW
 * @date 2026/7/10 8: 35
 * @Version 1.0
 */
public class ProblemsNo34 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        System.out.println("= res = " + searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = lowSearch(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = lowSearch(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            }  else {
                l = mid + 1;
            }
        }
        return l;
    }
}

