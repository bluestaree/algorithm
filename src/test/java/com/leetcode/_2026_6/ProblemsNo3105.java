package com.leetcode._2026_6;

import org.junit.Test;


/**
 * 3105. 最长的严格递增或递减子数组
 *
 * @author DHW
 * @date 2026/6/5 9: 22
 * @Version 1.0
 */
public class ProblemsNo3105 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,2,1};
        System.out.println("= res = " + longestMonotonicSubarray(nums));
    }

    public int longestMonotonicSubarray(int[] nums) {
        int x = 0;
        int y = 0;
        int a = 1;
        int b = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                a++;
                y = Math.max(b, y);
                b = 1;
            } else if(nums[i] < nums[i-1]) {
                b++;
                x = Math.max(a, x);
                a = 1;
            } else {
                x = Math.max(a, x);
                y = Math.max(b, y);
                a = 1;
                b = 1;
            }
        }
        x = Math.max(a, x);
        y = Math.max(b, y);
        return Math.max(x, y);
    }

}

