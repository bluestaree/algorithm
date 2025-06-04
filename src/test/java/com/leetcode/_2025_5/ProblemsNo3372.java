package com.leetcode._2025_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 3372. 连接两棵树后最大目标节点数目 I
 *
 * @author DHW
 * @date 2025/5/28 14: 38
 * @Version 1.0
*/
public class ProblemsNo3372 {

    @Test
    public void solution() {
        int[][] edges1 = new int[][]{new int[]{0,1},new int[]{0,2},new int[]{2,3},new int[]{2,4}};
        int[][] edges2 = new int[][]{new int[]{0,1},new int[]{0,2},new int[]{0,3},new int[]{2,7},new int[]{1,4},new int[]{4,5},new int[]{4,6}};
        int k = 2;
        System.out.println("res = " + maxTargetNodes(edges1, edges2, k));
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = new ArrayList[n];
        for (int i = 0; i < g1.length; i++) {
            g1[i] = new ArrayList();
        }
        List<Integer>[] g2 = new ArrayList[m];
        for (int i = 0; i < g2.length; i++) {
            g2[i] = new ArrayList();
        }
        for (int i = 0; i < edges1.length; i++) {
            int a = edges1[i][0];
            int b = edges1[i][1];
            g1[a].add(b);
            g1[b].add(a);
        }
        for (int i = 0; i < edges2.length; i++) {
            int a = edges2[i][0];
            int b = edges2[i][1];
            g2[a].add(b);
            g2[b].add(a);
        }

        int maxNum = 0;
        for (int i = 0; i < g2.length; i++) {
            maxNum = Math.max(maxNum, dfs(g2, i, -1, k - 1));
        }

        int[] res = new int[n];
        Arrays.fill(res, maxNum);

        for (int i = 0; i < res.length; i++) {
            res[i] += dfs(g1, i, -1, k);
        }
        return res;
    }

    private int dfs(List<Integer>[] g, int i, int pre, int k){
        if(k < 0) {
            return 0;
        }
        int cnt = 1;
        for (int next : g[i]) {
            if(next != pre) {
                cnt += dfs(g, next, i, k - 1);
            }

        }
        return cnt;
    }
}

