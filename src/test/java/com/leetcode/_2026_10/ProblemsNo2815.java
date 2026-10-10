package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2815. 数组中的最大数对和
 *
 * @author DHW
 * @date 2026/10/10 8:37
 * @Version 1.0
*/
public class ProblemsNo2815 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        System.out.println("res = " + maxSum(nums));
    }

    public int maxSum(int[] nums) {
        int[] a = new int[10];
        int ans = -1;
        Arrays.fill(a, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int c = -1;
            for (int x = num; x >0; x /= 10) {
                c = Math.max(c, x % 10);
            }
            if(a[c] != -1) {
                ans = Math.max(ans, a[c] + num);
            }
            a[c] = Math.max(num, a[c]);
        }
        return ans;
    }
}

