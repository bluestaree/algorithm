package com.leetcode._2026_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3708. 最长斐波那契子数组
 *
 * @author DHW
 * @date 2026/5/9 9: 37
 * @Version 1.0
 */
public class ProblemsNo3708 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,1,1,2,3,5,1};
        System.out.println("sortArrayByParity(nums) = " + longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int length = nums.length;
        if(length <= 2) return length;
        int ans = 2;
        int temp = 2;
        for (int i = 0, j = 2; i < length - 2; i++, j++) {
            if(nums[i] + nums[i+1] == nums[j]) {
                temp++;
                ans = Math.max(ans, temp);
            } else {
                temp = 2;
                if(length - i <= ans) {
                    break;
                }
            }
        }
        return ans;
    }
}

