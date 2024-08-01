package com.leetcode._2024_7;

import org.junit.Test;


/**
 * 2970. 统计移除递增子数组的数目 I
 *
 * @author DHW
 * @date 2024/7/10 10:19
 * @Version 1.0
*/
public class ProblemsNo2970 {

    @Test
    public void solution() {
        int[] nums = new int[]{8,7,6,6};
        System.out.println("res = " + incremovableSubarrayCount(nums));
    }

    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(checkIncrNums(nums,i,j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean checkIncrNums(int[] nums, int s, int e) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i < s || i > e) {
                if(nums[i] <= pre) {
                    return false;
                }
                pre = nums[i];
            }
        }
        return true;
    }
}

