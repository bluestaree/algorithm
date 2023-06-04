package com.leetcode._2023_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2441. 与对应负数同时存在的最大正整数
 *
 * @author DHW
 * @date 2023/5/13 10:04
 * @Version 1.0
 */
public class ProblemsNo2441 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println("res = " + findMaxK(nums));
    }

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length - 1] < 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int num = nums[i] + nums[j];
                if(nums[j] < 0 || num < 0) {
                    break;
                }
                if(num == 0) {
                    return nums[j];
                }
            }
        }
        return -1;
    }
}
