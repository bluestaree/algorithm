package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1334. 阈值距离内邻居最少的城市
 *
 * @author DHW
 * @date 2023/11/14 10:49
 * @Version 1.0
*/
public class ProblemsNo1334 {

    @Test
    public void solution() {
        int[][] edges = new int[][]{new int[]{0,1,10} ,new int[]{0,2,1},new int[]{2,3,1},new int[]{1,3,1},new int[]{1,4,1},new int[]{4,5,10}};
//        int[][] edges = new int[][]{new int[]{2,3,2} ,new int[]{1,3,10},new int[]{1,2,10},new int[]{0,2,4}};
        int n = 6;
        int distanceThreshold = 20;
        System.out.println("res = " + findTheCity(n, edges, distanceThreshold));
    }

    private List<List<Integer[]>> arrayList;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int z = edges[i][2];
            arrayList.get(x).add(new Integer[]{y,z});
            arrayList.get(y).add(new Integer[]{x,z});
        }

        int sum = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean[][] check = new boolean[n][n];
            boolean[] flag = new boolean[n];
            flag[i] = true;
            int num = countCityNum(i, flag, check, arrayList.get(i), distanceThreshold);
            if(num <= sum) {
                sum = num;
                res = i;
            }
        }
        return res;
    }

    private int countCityNum(int s, boolean[] flag, boolean[][] check, List<Integer[]> cur, int distance) {
        int count = 0;
        if(distance <= 0) {
            return count;
        }
        for (int j = 0; j < cur.size(); j++) {
            Integer y = cur.get(j)[0];
            if(check[s][y]) {
                continue;
            }
            Integer len = cur.get(j)[1];
            int nextDistance = distance - len;
            if(nextDistance >= 0) {
                check[s][y] = true;
                if(!flag[y]) {
                    count++;
                    flag[y] = true;
                }
                count += countCityNum(y, flag, check, arrayList.get(y), nextDistance);
            }
        }
        return count;
    }

    private int countCityNum1(boolean[] check, List<Integer[]> cur, int distance) {
        int count = 0;
        if(distance <= 0) {
            return count;
        }
        for (int j = 0; j < cur.size(); j++) {
            Integer y = cur.get(j)[0];
            if(check[y]) {
                continue;
            }
            Integer len = cur.get(j)[1];
            int nextDistance = distance - len;
            if(nextDistance >= 0) {
                check[y] = true;
                count += countCityNum1(check, arrayList.get(y), nextDistance) + 1;
            }
        }
        return count;
    }
}

