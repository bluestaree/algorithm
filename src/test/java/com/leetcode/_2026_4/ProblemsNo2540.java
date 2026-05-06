package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 2540. 最小公共值
 *
 * @author DHW
 * @date 2026/4/3 9: 52
 * @Version 1.0
 */
public class ProblemsNo2540 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,4};
        System.out.println("sortArrayByParity(nums) = " + getCommon(nums1, nums2));
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int ans = -1;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if(nums1[i] == nums2[j]) {
                ans = nums1[i];
                return ans;
            }
            if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }

}

