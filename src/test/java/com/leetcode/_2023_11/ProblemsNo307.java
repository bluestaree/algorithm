package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 307. 区域和检索 - 数组可修改
 *
 * @author DHW
 * @date 2023/11/13 10:09
 * @Version 1.0
 */
public class ProblemsNo307 {

    @Test
    public void solution() {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println("numArray = " + numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println("numArray = " +  numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
    }

    class NumArray {

        int nums[];
        int sum[];
        int len;

        public NumArray(int[] nums) {
            len = nums.length;
            this.nums = nums;
            sum = new int[len+1];
            for (int i = 0; i < nums.length; i++) {
                sum[i+1] = sum[i] + nums[i];
            }
        }

        public void update(int index, int val) {
            nums[index] = val;
            for (int i = index; i < len; i++) {
                sum[i+1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right+1] - sum[left];
        }
    }
}