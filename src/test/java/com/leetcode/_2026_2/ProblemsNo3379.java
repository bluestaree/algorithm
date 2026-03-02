package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 3379. 转换数组
 *
 * @author DHW
 * @date 2026/2/5 8: 50
 * @Version 1.0
*/
public class ProblemsNo3379 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,4,3,3};
        System.out.println("res = " + isTrionic(nums));
    }

    public int[] isTrionic(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[(i + nums[i] % n + n) % n];
        }
        return ans;
    }

}

