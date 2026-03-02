package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 930. 和相同的二元子数组
 *
 * @author DHW
 * @date 2026/2/3 9: 40
 * @Version 1.0
*/
public class ProblemsNo930 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,0,1,0,1};
        int goal = 2;
        System.out.println("res = " + numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums, goal) - slidingWindow(nums, goal + 1);
    }

    private int slidingWindow(int[] nums, int s) {
        int l = 0;
        int sum = 0;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l < r && sum >= s) {
                sum -= nums[l];
                l++;
            }
            count += l;
        }
        return count;
    }

}

