package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3514. 不同 XOR 三元组的数目 II
 *
 * @author DHW
 * @date 2026/7/24 8: 49
 * @Version 1.0
 */
public class ProblemsNo3514 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,5,2,1};
        System.out.println("= res = " + uniqueXorTriplets(nums));
    }

    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
        }
        int n = 1 << (32 - Integer.numberOfLeadingZeros(mx));
        boolean[] x1 = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                x1[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] x2 = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!x1[i]) {
                continue;
            }
            for (int z : nums) {
                x2[i ^ z] = true;
            }
        }

        int ans = 0;

        for (boolean b : x2) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}

