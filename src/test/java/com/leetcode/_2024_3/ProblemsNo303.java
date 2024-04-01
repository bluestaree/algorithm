package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author DHW
 * @date 2024/3/18 9:13
 * @Version 1.0
*/
public class ProblemsNo303 {

    @Test
    public void solution() {
        int[] nums = new int[]{-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,1);
        System.out.println("res = " +  param_1);
    }

    class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            int length = nums.length;
            sum = new int[length + 1];
            for (int i = 0; i < length; i++) {
                sum[i+1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right+1] - sum[left];
        }
    }

}

