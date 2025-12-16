package com.leetcode._2025_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


/**
 * 2536. 子矩阵元素加 1
 *
 * @author DHW
 * @date 2025/11/14 8: 31
 * @Version 1.0
*/
public class ProblemsNo2536 {

    @Test
    public void solution() {
        int n = 3;
        int[][] queries =  new int[][]{new int[]{1,1,2,2},new int[]{0,0,1,1}};
        System.out.println("res = " + rangeAddQueries(n, queries));
    }


    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
}

