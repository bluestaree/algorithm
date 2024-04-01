package com.leetcode._2024_3;

import org.junit.Test;

import java.util.*;


/**
 * 2642. 设计可以求最短路径的图类
 *
 * @author DHW
 * @date 2024/3/2 11:21
 * @Version 1.0
*/
public class ProblemsNo2642 {

    @Test
    public void solution() {
        int[][] edges = new int[][]{new int[]{0, 2, 5}, new int[]{0, 1, 2}, new int[]{1, 2, 1}, new int[]{3, 0, 3}};
        int n = 4;
        Graph obj = new Graph(n, edges);
        int param_2 = obj.shortestPath(3,2);
        System.out.println("param_2 = " + param_2);
    }

    class Graph {
        int NUM = Integer.MAX_VALUE / 2;
        int[][] grid;

        public Graph(int n, int[][] edges) {
            grid = new int[n][n];
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(grid[i], NUM);
            }
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] e) {
            grid[e[0]][e[1]] = e[2];
        }

        public int shortestPath(int start, int end) {
            int n = grid.length;
            int[] dis = new int[n];
            Arrays.fill(dis, NUM);
            dis[start] = 0;
            boolean[] v = new boolean[n];
            while(true) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if(!v[i] && (x < 0 || dis[i] < dis[x])) {
                        x = i;
                    }
                }
                // 全部节点已访问 / 存在无法到达节点
                if(x < 0 || dis[x] == NUM) {
                    return -1;
                }
                if(x == end) {
                    return dis[x];
                }
                // 标记当前节点已访问
                v[x] = true;
                for (int i = 0; i < n; i++) {
                    dis[i] = Math.min(dis[i], dis[x] + grid[x][i]);
                }
            }
        }
    }
}

