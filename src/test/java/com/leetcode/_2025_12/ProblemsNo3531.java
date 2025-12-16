package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3531. 统计被覆盖的建筑
 *
 * @author DHW
 * @date 2025/12/11 10: 14
 * @Version 1.0
*/
public class ProblemsNo3531 {

    @Test
    public void solution() {
        int n = 5;
        int[][] buildings = new int[][]{new int[]{2,1}, new int[]{2,3}, new int[]{3,3}, new int[]{2,2},new int[]{1,3}};
        System.out.println("res = " + countCoveredBuildings(n, buildings));
    }


    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        int[][] a = new int[n+1][2];
        for (int[] ints : a) {
            ints[0] = Integer.MAX_VALUE;
        }
        int[][] b = new int[n+1][2];
        for (int[] ints : b) {
            ints[0] = Integer.MAX_VALUE;
        }

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if(a[x][0] > y) {
                a[x][0] = y;
            }
            if(a[x][1] < y) {
                a[x][1] = y;
            }
            if(b[y][0] > x) {
                b[y][0] = x;
            }
            if(b[y][1] < x) {
                b[y][1] = x;
            }
        }

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if(a[x][0] < y && a[x][1] > y && b[y][0] < x && b[y][1] > x) {
                ans++;
            }
        }
        return ans;
    }
}

