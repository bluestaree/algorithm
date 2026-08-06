package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3867. 数对的最大公约数之和
 *
 * @author DHW
 * @date 2026/7/16 8: 35
 * @Version 1.0
 */
public class ProblemsNo3867 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,5,6};
        System.out.println("= res = " + gcdSum(nums));
    }

    public long gcdSum(int[] nums) {
        long ans = 0;
        int mx = 0;
        int n = nums.length;
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);
        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while(a != 0) {
            int t = a;
            a = b % a;
            b = t;
        }
        return b;
    }
}

