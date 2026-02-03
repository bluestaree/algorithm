package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2779. 数组的最大美丽值
 *
 * @author DHW
 * @date 2026/1/8 9: 13
 * @Version 1.0
*/
public class ProblemsNo2779 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6,1,2};
        int k = 2;
        System.out.println("res = " + maximumBeauty(nums, k));
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            while(nums[r] - nums[l] > 2 * k){
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

}

