package com.leetcode._2024_4;

import org.junit.Test;


/**
 * 2529. 正整数和负整数的最大计数
 *
 * @author DHW
 * @date 2024/4/9 9:10
 * @Version 1.0
*/
public class ProblemsNo2529 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1563,-236,-114,-55,427,447,687,752,1021,1636};
        System.out.println("res = " + maximumCount(nums));
    }

    public int maximumCount(int[] nums) {
        int n = nums.length;
        if(nums[0] > 0 || nums[n-1] < 0) {
            return n;
        }
        int a = search(nums, 0);
        int b = n - search(nums, 1);
        return Math.max(a, b);
    }

    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}

