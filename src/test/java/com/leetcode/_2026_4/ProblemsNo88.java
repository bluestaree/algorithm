package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 88. 合并两个有序数组
 *
 * @author DHW
 * @date 2026/4/7 9: 42
 * @Version 1.0
 */
public class ProblemsNo88 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{3,5,2,6};
        int[] nums2 = new int[]{10,10,15,12};
        int m = 1;
        int n = 2;
        merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        int i = nums1.length - 1;
        while (r >= 0) {
            if (l >= 0 && nums1[l] > nums2[r]) {
                nums1[i--] = nums1[l--];
            } else {
                nums1[i--] = nums2[r--];
            }
        }
    }

}

