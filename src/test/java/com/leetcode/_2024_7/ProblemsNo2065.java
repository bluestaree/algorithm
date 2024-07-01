package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2065. 最大化一张图中的路径价值
 *
 * @author DHW
 * @date 2024/7/1 9:28
 * @Version 1.0
*/
public class ProblemsNo2065 {

    @Test
    public void solution() {
        int[] values = new int[]{0,32,10,43};
        int[][] edges = new int[][]{new int[]{0,1,10},new int[]{1,2,15},new int[]{0,3,10}};
        int maxTime = 49;
        System.out.println("res = " + maximalPathQuality(values, edges, maxTime));
    }

    int value;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int len = edge[2];
            g[x].add(new int[]{y,len});
            g[y].add(new int[]{x,len});
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        dfs(values, vis, 0, values[0], g, maxTime);
        return value;
    }

    private void dfs(int[] values, boolean[] vis, int index, int num, List<int[]>[] g, int maxTime) {
        if(index == 0) {
            value = Math.max(value, num);
        }
        for (int[] info : g[index]) {
            if(maxTime - info[1] < 0) {
                continue;
            }
            if(vis[info[0]]) {
                dfs(values, vis, info[0], num, g, maxTime - info[1]);
            } else {
                vis[info[0]] = true;
                dfs(values, vis, info[0], num + values[info[0]], g, maxTime - info[1]);
                vis[info[0]] = false;
            }
        }
    }
}

