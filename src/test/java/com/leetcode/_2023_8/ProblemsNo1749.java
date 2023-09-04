package com.leetcode._2023_8;

import org.junit.Test;

import java.util.HashSet;


/**
 * 1749. 任意子数组和的绝对值的最大值
 *
 * @author DHW
 * @date 2023/8/8 9:19
 * @Version 1.0
*/
public class ProblemsNo1749 {

    @Test
    public void solution() {
        int[] nums = new int[]{-2,-1,8,9,6};
        System.out.println("res = " + maxAbsoluteSum(nums));
    }

    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int num : nums) {
            sum += num;
            if(sum > max) {
                max = sum;
            }
            if(sum < min) {
                min = sum;
            }
        }
        return max - min;
    }
}
