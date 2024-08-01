package com.leetcode._2024_7;

import org.junit.Test;


/**
 * 724. 寻找数组的中心下标
 *
 * @author DHW
 * @date 2024/7/8 11:00
 * @Version 1.0
*/
public class ProblemsNo724 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if(s[i] == s[n] - s[i+1]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            right += nums[i];
        }
        for (int i = 0; i < n; i++) {
            right -= nums[i];
            if(left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}

