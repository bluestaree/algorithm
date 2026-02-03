package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 1658. 将 x 减到 0 的最小操作数
 *
 * @author DHW
 * @date 2026/1/6 13: 54
 * @Version 1.0
*/
public class ProblemsNo1658 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,4,2,3};
        int x = 5;
        System.out.println("res = " + minOperations(nums, x));
    }

    public int minOperations(int[] nums, int x) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = 0;
        int target = sum - x;

        int s = 0;
        for (int r = 0; r < nums.length; r++) {
            s += nums[r];
            while (s > target && l <= r) {
                s -= nums[l];
                l++;
            }
            if(s == target){
                ans = Math.min(ans, nums.length - r + l - 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}

