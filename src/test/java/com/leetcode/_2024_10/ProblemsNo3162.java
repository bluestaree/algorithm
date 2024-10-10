package com.leetcode._2024_10;

import org.junit.Test;


/**
 * 3162. 优质数对的总数 I
 *
 * @author DHW
 * @date 2024/10/10 8:53
 * @Version 1.0
*/
public class ProblemsNo3162 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{4,8,2,8};
        int[] nums2 = new int[]{4,8,2,8};
        int k = 4;
        System.out.println("res = " + numberOfPairs(nums1, nums2, k));
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for (int x : nums1) {
            for (int y : nums2) {
                if (x % (y * k) == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}

