package com.leetcode._2023_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1043. 分隔数组以得到最大和
 *
 *
 * @author DHW
 * @date 2023/4/19 10:26
 * @Version 1.0
*/
public class ProblemsNo1043 {

    private int[] arr, memo;
    private int k;

    @Test
    public void solution() {
        int[] arr = new int[]{1,15,7,9,2,5,10};
        int k = 3;
        System.out.println("res = " + maxSumAfterPartitioning(arr, k));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n - 1);
    }

    public int dfs(int i) {
        if(i < 0) return 0;
        int res = 0;
        if(memo[i] != -1) {
            return memo[i];
        }
        for (int j = i,mx = 0; j >= 0 && j > i - k ; j--) {
            mx = Math.max(mx, arr[j]);
            res = Math.max(res, dfs(j - 1) + (i - j + 1) * mx);
        }
        memo[i] = res;
        return memo[i];
    }
}
