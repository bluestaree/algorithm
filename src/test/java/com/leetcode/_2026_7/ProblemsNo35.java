package com.leetcode._2026_7;

import org.junit.Test;


/**
 * 35. 搜索插入位置
 *
 * @author DHW
 * @date 2026/7/13 9: 50
 * @Version 1.0
 */
public class ProblemsNo35 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        System.out.println("= res = " + searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
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
        return l;
    }
}

