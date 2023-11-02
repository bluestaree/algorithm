package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2731. 移动机器人
 *
 * @author DHW
 * @date 2023/10/10 9:06
 * @Version 1.0
*/
public class ProblemsNo2731 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3};
        String s = "RLL";
        int d = 3;
        System.out.println("res = " + sumDistance(nums, s, d));
    }

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < nums.length; i++) {
            if(s.charAt(i) == 'R') {
                arr[i] = nums[i] + d;
            } else {
                arr[i] = nums[i] - d;
            }
        }
        Arrays.sort(arr);
        long res = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            long dis = (arr[i] - arr[i-1]) % mod;
            res = (res + dis * i * (n-i)) % mod;
        }
        return (int) res;
    }
}

