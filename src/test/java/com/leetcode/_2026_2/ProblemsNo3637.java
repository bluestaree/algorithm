package com.leetcode._2026_2;

import org.junit.Test;

import java.util.HashMap;


/**
 * 3637. 三段式数组 I
 *
 * @author DHW
 * @date 2026/2/3 9: 50
 * @Version 1.0
*/
public class ProblemsNo3637 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,4,3,3};
        System.out.println("res = " + isTrionic(nums));
    }

    public boolean isTrionic(int[] nums) {
        int state = 0;
        int n = nums.length;
        int p = -1;
        int q = n - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if(state % 2 == 0 && nums[i] <= nums[i-1]) {
                if(p != -1) {
                    return false;
                }
                p = i - 1;
                state++;
                continue;
            }
            if(state % 2 == 1 && nums[i] >= nums[i-1]) {
                if(q != n - 1) {
                    return false;
                }
                q = i - 1;
                state++;
            }
        }
        return p !=0 && q != n - 1;
    }

}

