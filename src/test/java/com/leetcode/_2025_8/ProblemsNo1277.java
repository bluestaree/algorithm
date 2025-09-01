package com.leetcode._2025_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1277. 统计全为 1 的正方形子矩阵
 *
 * @author DHW
 * @date 2025/8/20 9: 26
 * @Version 1.0
*/
public class ProblemsNo1277 {

    @Test
    public void solution() {
        int[][] matrix =  new int[][]{new int[]{0,1,1,1},new int[]{1,1,1,1},new int[]{0,1,1,1}};
        System.out.println("res = " + countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != 1) {
                    continue;
                }
                ans++;
                for (int step = 1; i + step < m && j + step < n; step++) {
                    int a = i + step;
                    int b = j + step;
                    int x = step;
                    boolean flag = true;
                    for (; x >= 0; x--) {
                        if(matrix[a][b-x] != 1 || matrix[a-x][b] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

