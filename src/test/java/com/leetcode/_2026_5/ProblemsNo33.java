package com.leetcode._2026_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 33. 搜索旋转排序数组
 *
 * @author DHW
 * @date 2026/5/22 8: 41
 * @Version 1.0
 */
public class ProblemsNo33 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("res = " + search(nums, target));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int rx = nums[n-1];
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int x = nums[mid];
            if(target > rx && x <= rx) {
                r = mid;
            } else if(target <= rx && x > rx) {
                l = mid + 1;
            } else if (x >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

}

