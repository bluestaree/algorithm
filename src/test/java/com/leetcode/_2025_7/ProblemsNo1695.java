package com.leetcode._2025_7;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 1695. 删除子数组的最大得分
 *
 * @author DHW
 * @date 2025/7/22 9: 30
 * @Version 1.0
*/
public class ProblemsNo1695 {

    @Test
    public void solution() {
        int[] nums =  new int[]{2,5};
        System.out.println("res = " + maximumUniqueSubarray(nums));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int[] a = new int[10001];
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res  = 0;
        int b = 0;
        for (int i = 1; i <= n; i++) {
            int v = nums[i - 1];
            b = Math.max(b, a[v]);
            res = Math.max(res, sum[i] - sum[b]);
            a[v] = i;
        }
        return res;
    }

}

