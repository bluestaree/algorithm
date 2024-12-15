package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3238. 求出胜利玩家的数目
 *
 * @author DHW
 * @date 2024/11/23 11: 27
 * @Version 1.0
*/
public class ProblemsNo3238 {

    @Test
    public void solution() {
        int n = 2;
        int[][] pick = {new int[]{1,4}, new int[]{1,2}};
        System.out.println("res = " + winningPlayerCount(n, pick));
    }

    public int winningPlayerCount(int n, int[][] pick) {
        int res = 0;
        int[] vis = new int[n];
        int[][] a = new int[n][11];
        for (int[] b : pick) {
            if(vis[b[0]] == 1) {
                continue;
            }
            a[b[0]][b[1]]++;
            if(a[b[0]][b[1]] > b[0]) {
                vis[b[0]] = 1;
                res++;
            }
        }
        return res;
    }
}

