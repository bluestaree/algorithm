package com.leetcode._2026_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2439. 最小化数组中的最大值
 *
 * @author DHW
 * @date 2026/9/15 8:37
 * @Version 1.0
*/
public class ProblemsNo2439 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,0,1,4};
        System.out.println("res = " + minimizeArrayValue(nums));
    }

    public int minimizeArrayValue(int[] nums) {
        int l = nums[0] - 1;
        int r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, nums)) {
               r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > (long)(i + 1) * mid) {
                return false;
            }
        }
        return true;
    }
}

