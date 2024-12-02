package com.leetcode._2024_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 743. 网络延迟时间
 *
 * @author DHW
 * @date 2024/11/25 10: 31
 * @Version 1.0
*/
public class ProblemsNo743 {

    @Test
    public void solution() {
        int[][] times = new int[][]{new int[]{0,1}, new int[]{0,1}, new int[]{0,0}};

        System.out.println("res = " + networkDelayTime(times, 2,8));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            g[t[0]- 1].add(new int[]{t[1]-1, t[2]});
        }

        int maxDis = 0;
        int left = n;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k-1] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, k-1});
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int dx = p[0];
            int x = p[1];
            if(dx > dis[x]) {
                continue;
            }
            maxDis = dx;
            left--;
            for (int[] e : g[x]) {
                int y = e[0];
                int newDis = dx + e[1];
                if(newDis < dis[y]) {
                    dis[y] = newDis;
                    queue.offer(new int[]{newDis, y});
                }
            }
        }
        return left == 0 ? maxDis : -1;

    }
}

