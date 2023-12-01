package com.leetcode._2023_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2661. 找出叠涂元素
 *
 * @author DHW
 * @date 2023/12/1 10:27
 * @Version 1.0
*/
public class ProblemsNo2661 {

    @Test
    public void solution() {
        int[] arr = new int[]{6,2,3,1,4,5};
        int[][] mat = new int[][]{new int[]{5,1},new int[]{2,4},new int[]{6,3}};
        System.out.println("res = " + firstCompleteIndex(arr, mat));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        int[][] pos = new int[arr.length+1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[mat[i][j]][0] = i;
                pos[mat[i][j]][1] = j;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(++rowCount[pos[arr[i]][0]] == n || ++colCount[pos[arr[i]][1]] == m) {
                res = i;
                break;
            }
        }
        return res;
    }
}

