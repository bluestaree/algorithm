package com.leetcode._2025_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3363. 最多可收集的水果数目
 *
 * @author DHW
 * @date 2025/8/7 9: 11
 * @Version 1.0
*/
public class ProblemsNo3363 {

    @Test
    public void solution() {
        int[][] fruits =  new int[][]{new int[]{1,2,3,4},new int[]{5,6,8,7},new int[]{9,10,11,12},new int[]{13,14,15,16}};
        System.out.println("res = " + maxCollectedFruits(fruits));
    }

    public int maxCollectedFruits(int[][] fruits) {
        int ans = 0;
        int n = fruits.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(fruits[i], -1);
        }
        f[0][n - 1] = fruits[0][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1]) + fruits[i][j];
                if(j < n - 1) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j + 1] + fruits[i][j]);
                }
            }
        }
        f[n-1][0] = fruits[n-1][0];
        for (int j = 1; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j - 1]) + fruits[i][j];
                if(i < n - 1) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + fruits[i][j]);
                }
            }
        }
        ans = f[n - 2][n - 1] + f[n - 1][n - 2];
        for (int i = 0; i < n; i++) {
            ans += fruits[i][i];
        }
        return ans;
    }
}

