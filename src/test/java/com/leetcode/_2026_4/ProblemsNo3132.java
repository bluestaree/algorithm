package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 3132. 找出与数组相加的整数 II
 *
 * @author DHW
 * @date 2026/4/23 9: 42
 * @Version 1.0
 */
public class ProblemsNo3132 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{3,5,2,6};
        int[] nums2 = new int[]{10,10,15,12};
        System.out.println("sortArrayByParity(nums) = " + minimumAddedInteger(nums1, nums2));
    }


    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];
            int j = 0;
            for (int k = i; k < nums1.length; k++) {
                if(nums1[k] + x == nums2[j] && ++j == nums2.length) {
                    return x;
                }
            }
        }
        return nums1[0] - nums2[0];
    }

}

