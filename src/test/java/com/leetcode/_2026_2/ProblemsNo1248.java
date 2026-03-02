package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 1248. 统计「优美子数组」
 *
 * @author DHW
 * @date 2026/2/6 9: 06
 * @Version 1.0
*/
public class ProblemsNo1248 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,0,1,0,1};
        int k = 2;
        System.out.println("res = " + numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k + 1);
    }

    private int slidingWindow(int[] nums, int s) {
        int ans = 0;
        int l = 0;
        int count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) {
                count++;
            }
            while (count == s) {
                if (nums[l] % 2 == 1) {
                    count--;
                }
                l++;
            }
            ans += l;
        }

        return ans;
    }

}

