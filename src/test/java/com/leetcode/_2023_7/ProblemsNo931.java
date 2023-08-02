package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * 931. 下降路径最小和
 *
 * @author DHW
 * @date 2023/7/13 9:11
 * @Version 1.0
*/
public class ProblemsNo931 {

    @Test
    public void solution() {
        int[][] matrix = new int[][]{new int[]{-19,57}, new int[]{-40,-5}};
        System.out.println("res = " + findCrossingTime1(matrix));
    }

    int[][] matrix;
    int[][] cache;

    public int findCrossingTime(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        this.matrix = matrix;
        int length = matrix.length;
        cache = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < length; i++) {
            res = Math.min(res, dfs(0, i));
        }
        return res;
    }

    private int dfs(int i, int j) {
        if(j >= matrix.length || j < 0) {
           return Integer.MAX_VALUE;
        }
        if(i == matrix.length - 1) {
            return matrix[i][j];
        }
        if(cache[i][j] != Integer.MAX_VALUE) {
           return cache[i][j];
        }
        return cache[i][j] = Math.min(Math.min(dfs(i+1,j-1), dfs(i+1,j+1)), dfs(i+1,j)) + matrix[i][j];
    }


    public int findCrossingTime1(int[][] matrix) {
        int length = matrix.length;
        int[][] db = new int[length][length];
        System.arraycopy(matrix[0], 0, db[0], 0, length);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int mn = db[i-1][j];
                if(j >= 1) {
                    mn = Math.min(db[i-1][j-1], mn);
                }
                if(j < length - 1) {
                    mn = Math.min(db[i-1][j+1], mn);
                }
                db[i][j] = mn + matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.min(res, db[length-1][i]);
        }

        return res;
    }
}
