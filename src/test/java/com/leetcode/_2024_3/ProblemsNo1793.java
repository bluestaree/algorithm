package com.leetcode._2024_3;

import org.junit.Test;



/**
 * 1793. 好子数组的最大分数
 *
 * @author DHW
 * @date 2024/3/2 11:21
 * @Version 1.0
*/
public class ProblemsNo1793 {

    @Test
    public void solution() {
        int k = 1;
        int[] nums = new int[]{4,2,1};
        System.out.println("res = " + maximumScore(nums, k));
    }

    public int maximumScore(int[] nums, int k) {
        int left = k,right = k;
        int min = nums[k];
        int ans = nums[k];
        while(right < nums.length - 1 || left > 0) {
            if(right == nums.length - 1 || left > 0 && nums[left-1] > nums[right+1]) {
                min = Math.min(min, nums[--left]);
            } else {
                min = Math.min(min, nums[++right]);
            }
            ans = Math.max(ans, min * (right - left + 1));
        }
        return ans;
    }
}

