package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 826. 安排工作以达到最大收益
 *
 * @author DHW
 * @date 2024/5/17 9:42
 * @Version 1.0
*/
public class ProblemsNo826 {

    @Test
    public void solution() {
        int[] difficulty = new int[]{95,46,47,97,11,35,99,56,41,92};
        int[] profit = new int[]{95,46,47,97,11,35,99,56,41,92};
        int[] worker = new int[]{95,46,47,97,11,35,99,56,41,92};
        System.out.println("res = " + maxProfitAssignment(difficulty, profit, worker));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i][0] = difficulty[i];
            g[i][1] = profit[i];
        }
        Arrays.sort(worker);
        Arrays.sort(g, (a,b) -> a[0] - b[0]);
        int res = 0,j = 0,mx = 0;
        for (int i = 0; i < worker.length; i++) {

            while (i < n && g[i][0] <= worker[i]) {
                mx = Math.max(mx, g[i++][1]);
            }
            res += mx;
        }
        return res;
    }

//    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
//        int n = difficulty.length;
//        int[][] g = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            g[i][0] = difficulty[i];
//            g[i][1] = profit[i];
//        }
//        Arrays.sort(g, (a,b) -> a[0] - b[0]);
//        g[0][2] = g[0][1];
//        for (int i = 1; i < n; i++) {
//            g[i][2] = Math.max(g[i-1][2], g[i][1]);
//            if(g[i-1][0] == g[i][0]) {
//                g[i-1][2] = g[i][2];
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < worker.length; i++) {
//            res += bsearch(worker[i], 0, n - 1, g);
//        }
//        return res;
//    }
//    private int bsearch(int target, int left, int right, int[][] g) {
//        if(right < 0) {
//            return 0;
//        }
//        if(left  > right) {
//            return g[right][2];
//        }
//        int mid = (left + right) / 2;
//        if(g[mid][0] > target) {
//            return bsearch(target, left, mid - 1, g);
//        }
//        if(g[mid][0] < target) {
//            return bsearch(target, mid + 1, right, g);
//        }
//        return g[mid][2];
//    }
}

