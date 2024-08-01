package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 3112. 访问消失节点的最少时间
 *
 * @author DHW
 * @date 2024/7/1 9:28
 * @Version 1.0
*/
public class ProblemsNo3112 {

    @Test
    public void solution() {
        int[] disappear = new int[]{1,1,5};
        int[][] edges = new int[][]{new int[]{0,1,2},new int[]{1,2,1},new int[]{0,2,4}};
        int n = 3;
        System.out.println("res = " + minimumTime(n, edges, disappear));
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int len = edge[2];
            g[x].add(new int[]{y,len});
            g[y].add(new int[]{x,len});
        }
        int[] res = new int[n];
        Arrays.fill(res , -1);
        res[0] = 0;
        boolean[] v = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int dis = p[0];
            int x = p[1];
            if(v[x]) {
                continue;
            }
            v[x] = true;
            for (int[] e : g[x]) {
                int y = e[0];
                int newDis = dis + e[1];
                if((res[y] < 0 || newDis < res[y]) && newDis < disappear[y]) {
                    res[y] = newDis;
                    pq.offer(new int[]{newDis, y});
                }
            }
        }
        return res;
    }
}

