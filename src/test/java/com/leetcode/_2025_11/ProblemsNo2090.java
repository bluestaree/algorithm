package com.leetcode._2025_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2090. 半径为 k 的子数组平均值
 *
 * @author DHW
 * @date 2025/11/28 8: 47
 * @Version 1.0
*/
public class ProblemsNo2090 {

    @Test
    public void solution() {
        int[] nums =  new int[]{7,4,3,9,1,8,5,2,6};
        int k = 3;
        System.out.println("res = " + getAverages(nums, k));
    }

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            int k1 = 2 * k;
            if(i < k1) {
                continue;
            }
            ans[i - k] = (int) (s / (k1+1));
            s -= nums[i - k1];
        }
        return ans;
    }
}

