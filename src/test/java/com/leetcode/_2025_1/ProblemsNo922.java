package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 922. 按奇偶排序数组 II
 *
 * @author DHW
 * @date 2025/1/3 10: 22
 * @Version 1.0
*/
public class ProblemsNo922 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println("res = " + sortArrayByParityII(nums));
    }

    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        return nums;
    }
}

