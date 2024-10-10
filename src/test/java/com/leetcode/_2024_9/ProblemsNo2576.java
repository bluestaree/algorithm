package com.leetcode._2024_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2576. 求出最多标记下标
 *
 * @author DHW
 * @date 2024/9/12 8:48
 * @Version 1.0
*/
public class ProblemsNo2576 {

    @Test
    public void solution() {
        int[] nums = new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40};
        System.out.println("res = " + maxNumOfMarkedIndices(nums));
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        for (int j = (n + 1) / 2; j < n; ++j) {
            if (nums[i] * 2 <= nums[j]) {
                ++i;
            }
        }
        return i * 2;
    }
}

