package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3132. 找出与数组相加的整数 II
 *
 * @author DHW
 * @date 2024/8/9 9:11
 * @Version 1.0
*/
public class ProblemsNo3132 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{4,6,3,1,4,2,10,9,5};
        int[] nums2 = new int[]{5,10,3,2,6,1,9};
        System.out.println("res = " + minimumAddedInteger(nums1, nums2));
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int cur = nums2[0] - nums1[i];
            if(f(nums1, nums2, cur)) {
                min = Math.min(min, cur);
            }
        }
        return min;
    }

    private boolean f(int[] nums1, int[] nums2, int num) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        while(l < nums1.length && r < nums2.length && cnt <= 2) {
            if(nums2[r] - nums1[l] != num) {
                cnt++;
            } else {
                r++;
            }
            l++;
        }
        return cnt <= 2;
    }
}

