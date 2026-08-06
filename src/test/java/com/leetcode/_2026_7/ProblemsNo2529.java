    package com.leetcode._2026_7;

import org.junit.Test;


/**
 * 744. 寻找比目标字母大的最小字母
 *
 * @author DHW
 * @date 2026/7/15 9: 13
 * @Version 1.0
 */
public class ProblemsNo2529 {

    @Test
    public void solution() {
        int[] nums = new int[]{-3,-2,-1,0,0,1,2};
        System.out.println("= res = " + maximumCount(nums));
    }

    public int maximumCount(int[] nums) {
        int l = search(nums, 0);
        int r = search(nums, 1);
        return Math.max(l, nums.length - r);
    }

    private int search(int[] nums, int i) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= i) {
                high = mid - 1;
            }  else {
                low = mid + 1;
            }
        }
        return low;
    }
}

