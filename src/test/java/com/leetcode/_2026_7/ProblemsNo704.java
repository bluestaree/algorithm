package com.leetcode._2026_7;

import org.junit.Test;


/**
 * 704. 二分查找
 *
 * @author DHW
 * @date 2026/7/14 8: 50
 * @Version 1.0
 */
public class ProblemsNo704 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        System.out.println("= res = " + search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

