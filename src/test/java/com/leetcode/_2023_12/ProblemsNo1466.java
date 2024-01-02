package com.leetcode._2023_12;

import org.junit.Test;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;


/**
 * 1466. 重新规划路线
 *
 * @author DHW
 * @date 2023/12/7 9:47
 * @Version 1.0
*/
public class ProblemsNo1466 {

    @Test
    public void solution() {
        int n = 6;
        int[][] connections = new int[][]{new int[]{5,1},new int[]{2,4},new int[]{6,3}};
        System.out.println("res = " + minReorder(n, connections));
    }

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] d = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            d[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {
            int start = connections[i][0];
            int end = connections[i][1];
            d[start].add(new int[]{end, 1});
            d[end].add(new int[]{start, 0});
        }
        return dfs(0, -1, d);
    }

    private int dfs(int cur, int parent, List<int[]>[] d) {
        int res = 0;
        for (int[] e : d[cur]) {
            int b = e[0], c = e[1];
            if (b != parent) {
                res += c + dfs(b, cur, d);
            }
        }
        return res;
    }
}

