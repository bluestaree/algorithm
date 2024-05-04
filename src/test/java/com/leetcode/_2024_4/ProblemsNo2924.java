package com.leetcode._2024_4;

import org.junit.Test;


/**
 * 2924. 找到冠军 II
 *
 * @author DHW
 * @date 2024/4/13 10:23
 * @Version 1.0
*/
public class ProblemsNo2924 {

    @Test
    public void solution() {
        int[][] edges = new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{0,5}, new int[]{0,4}, new int[]{3,2}, new int[]{6,5}};
        int n = 6;
        System.out.println("res = " + findChampion(6, edges));
    }

    public int findChampion(int n, int[][] edges) {
        int[] countIn = new int[n];
        for (int[] edge : edges) {
            countIn[edge[1]]++;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < countIn.length; i++) {
            if(countIn[i] == 0) {
                count++;
                res = i;
            }
        }
        return count == 1 ? res:-1;
    }

}

