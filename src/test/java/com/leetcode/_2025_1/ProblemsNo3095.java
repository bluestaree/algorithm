package com.leetcode._2025_1;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3095. 或值至少 K 的最短子数组 I
 *
 * @author DHW
 * @date 2022/1/16 8: 36
 * @Version 1.0
*/
public class ProblemsNo3095 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        int k = 2;
        System.out.println("res = " + minimumSubarrayLength(nums,k));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = l + i;
            while(r < nums.length) {
                int num = 0;
                for (int j = l; j <= r; j++) {
                    num |= nums[j];
                }
                if(num >= k) {
                    return i+1;
                }
                l++;
                r++;
            }
        }
        return -1;
    }
}

