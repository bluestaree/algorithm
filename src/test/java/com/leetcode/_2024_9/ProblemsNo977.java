package com.leetcode._2024_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 977. 有序数组的平方
 *
 * @author DHW
 * @date 2024/9/8 10: 49
 * @Version 1.0
*/
public class ProblemsNo977 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        System.out.println("res = " + sortedSquares(nums));
    }

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0, j = len - 1,k = len - 1; i <=j;k--) {
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if(a > b) {
                res[k] = a;
                i++;
            } else {
                res[k] = b;
                j--;
            }
        }
        return res;
    }
}

