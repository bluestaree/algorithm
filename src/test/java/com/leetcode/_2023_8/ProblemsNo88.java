package com.leetcode._2023_8;

import org.junit.Test;

import java.util.HashSet;


/**
 * 88. 合并两个有序数组
 *
 * @author DHW
 * @date 2023/8/13 11:23
 * @Version 1.0
*/
public class ProblemsNo88 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{-2,-1,8,9,6};
        int[] nums2 = new int[]{-2,-1,8,9,6};
        int m = 1;
        int n = 2;
        merge(nums1, m, nums2, n);
        System.out.println("res = " + nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 || n > 0) {
            if(n == 0){
                return;
            }
            if(m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }
}
