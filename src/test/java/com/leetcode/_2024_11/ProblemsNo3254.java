package com.leetcode._2024_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3254. 长度为 K 的子数组的能量值 I
 *
 * @author DHW
 * @date 2024/11/6 8: 42
 * @Version 1.0
*/
public class ProblemsNo3254 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,3,4,3,2,5};
        int k = 3;
        System.out.println("res = " + resultsArray(nums, k));
    }

    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        int cnt = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            cnt = i == 0 || nums[i-1] + 1 == nums[i] ? cnt + 1 : 1;
            if(cnt >= k) {
                res[i-k+1] = nums[i];
            }
        }
        return res;
    }
}

