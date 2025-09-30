package com.leetcode._2025_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2221. 数组的三角和
 *
 * @author DHW
 * @date 2025/9/30 8: 52
 * @Version 1.0
*/
public class ProblemsNo2221 {

    @Test
    public void solution() {
        int[] nums =  new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("res = " + triangularSum(nums));
    }

    public int triangularSum(int[] nums) {
        while (nums.length > 1) {
            int[] newNums = new int[nums.length - 1];
            for (int i = 0; i < newNums.length; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = newNums;
        }
        return nums[0];
    }

}

