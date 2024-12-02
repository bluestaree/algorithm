package com.leetcode._2024_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3255. 长度为 K 的子数组的能量值 II
 *
 * @author DHW
 * @date 2024/11/7 8: 43
 * @Version 1.0
*/
public class ProblemsNo3255 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,4,3,2,5};
        int k = 4;
        System.out.println("res = " + resultsArray(nums, k));
    }

    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if(cnt >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }
}

