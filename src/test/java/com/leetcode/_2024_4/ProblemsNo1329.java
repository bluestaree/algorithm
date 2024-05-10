package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * 1329. 将矩阵按对角线排序
 *
 * @author DHW
 * @date 2024/4/29 9:24
 * @Version 1.0
*/
public class ProblemsNo1329 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{3,3,1,1},new int[]{2,2,1,2},new int[]{1,1,1,2}};
        System.out.println("res = " + diagonalSort(grid));
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer>[] sortList = new List[n+m];
        Arrays.setAll(sortList, x -> new ArrayList<>());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sortList[m-i+j].add(mat[i][j]);
            }
        }
        Arrays.stream(sortList).forEach(x -> Collections.sort(x, (a , b) -> b - a));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sortList[m-i+j].remove(sortList[m-i+j].size() - 1);
            }
        }
        return mat;
    }

}

