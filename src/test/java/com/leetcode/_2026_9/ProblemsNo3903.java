package com.leetcode._2026_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3903. 最小稳定下标 I
 *
 * @author DHW
 * @date 2026/9/04 8:37
 * @Version 1.0
*/
public class ProblemsNo3903 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,0,1,4};
        int k = 10;
        System.out.println("res = " + firstStableIndex(nums, k));
    }

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int[] mins = new int[n+1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int j = nums.length - 1; j >= 0; j--) {
            mins[j] = Math.min(mins[j+1], nums[j]);
        }
        int max = nums[i];
        while (i < nums.length) {
            max = Math.max(max, nums[i]);
            if(max - mins[i] <= k) {
               return i;
            }
            i++;
        }
        return -1;
    }
}

