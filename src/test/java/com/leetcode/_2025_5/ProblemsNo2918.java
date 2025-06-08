package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 2918. 数组的最小相等和
 *
 * @author DHW
 * @date 2025/5/10 8: 56
 * @Version 1.0
*/
public class ProblemsNo2918 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{2,3,12,0,4,6,7};
        int[] nums2 = new int[]{2,3,12,0,4,6,7};
        System.out.println("res = " + minSum(nums1, nums2));
    }

    public long minSum(int[] nums1, int[] nums2) {
        int countA = 0, countB = 0;
        int sumA = 0 ,sumB = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i] == 0) {
                countA++;
            } else {
                sumA += nums1[i];
            }
        }


        for (int i = 0; i < nums2.length; i++) {
            if(nums2[i] == 0) {
                countB++;
            } else {
                sumB += nums2[i];
            }
        }

        long x = sumA + countA;
        long y = sumB + countB;
        if(x > y && countB == 0 || y > x && countA == 0) {
            return -1;
        }
        return Math.max(x, y);
    }
}

