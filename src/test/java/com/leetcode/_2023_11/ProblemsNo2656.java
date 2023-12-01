package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 2656. K 个元素的最大和
 *
 * @author DHW
 * @date 2023/11/15 9:53
 * @Version 1.0
 */
public class ProblemsNo2656 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 5;
        System.out.println("minimum = " + maximizeSum(nums, k));
    }

    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        return  (2 * nums[nums.length - 1] + k - 1)* k /2;
    }
}