package com.leetcode._2024_5;

import org.junit.Test;

import java.util.*;


/**
 * 2965. 找出缺失和重复的数字
 *
 * @author DHW
 * @date 2024/5/31 9:10
 * @Version 1.0
*/
public class ProblemsNo2965 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{2,3},new int[]{1,3}};
        System.out.println("res = " + findMissingAndRepeatedValues(grid));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        for (int[] row : grid) {
            for (int a : row) {
                count[a]++;
            }
        }
        int[] res =  new int[2];
        for (int i = 1; i < count.length; i++) {
            if(count[i]==0) {
                res[1] = i;
            } else if(count[i]==2) {
                res[0] = i;
            }
        }
        return res;
    }
}

