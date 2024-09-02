package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3131. 找出与数组相加的整数 I
 *
 * @author DHW
 * @date 2024/8/8 10:00
 * @Version 1.0
*/
public class ProblemsNo3131 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{7,4,1};
        int[] nums2 = new int[]{7,4,1};
        int cnt = 1;
        System.out.println("res = " + addedInteger(nums1, nums2));
    }

    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }
}

