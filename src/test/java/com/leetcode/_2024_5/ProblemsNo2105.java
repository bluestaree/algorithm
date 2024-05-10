package com.leetcode._2024_5;

import org.junit.Test;


/**
 * 2105. 给植物浇水 II
 *
 * @author DHW
 * @date 2024/5/9 9:35
 * @Version 1.0
*/
public class ProblemsNo2105 {

    @Test
    public void solution() {
        int[] plants = new int[]{2,2,3,3};
        int capacityA = 5;
        int capacityB = 5;
        System.out.println("res = " + minimumRefill(plants, capacityA, capacityB));
    }

    int res = 0;
    int n;
    int[][] g;
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        n = plants.length;
        g = new int[][]{new int[]{0, capacityA}, new int[]{n-1, capacityB}};
        while(g[0][0] < g[1][0]) {
            f(0, plants, capacityA);
            f(1, plants, capacityB);
            g[0][0]++;
            g[1][0]--;
        }
        if(g[0][0] == g[1][0] && Math.max(g[0][1], g[1][1]) < plants[g[0][0]]) {
            res++;
        }
        return res;
    }

    private void f(int x, int[] plants, int capacity) {
        g[x][1] = g[x][1] - plants[g[x][0]];
        if (g[x][1] < 0) {
            g[x][1] = capacity -  plants[g[x][0]];
            res++;
        }
    }
}

