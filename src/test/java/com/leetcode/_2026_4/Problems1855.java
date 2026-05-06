package com.leetcode._2026_4;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1855. 下标对中的最大距离
 *
 * @author DHW
 * @date 2026/4/8 9: 46
 * @Version 1.0
 */
public class Problems1855 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{3,5,2,6};
        int[] nums2 = new int[]{10,10,15,12};
        maxDistance(nums1, nums2);
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int i = 0;
        for (int j = 0; j < nums2.length; j++) {
            while(i < nums1.length && nums1[i] > nums2[j]) {
                i++;
            }
            if(i == nums1.length) {
                break;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

}

