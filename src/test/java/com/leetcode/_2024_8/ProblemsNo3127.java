package com.leetcode._2024_8;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 3127. 构造相同颜色的正方形
 *
 * @author DHW
 * @date 2024/8/31 10:34
 * @Version 1.0
*/
public class ProblemsNo3127 {

    @Test
    public void solution() {
        char[][] grid = new char[][]{new char[]{'B','W','B'},new char[]{'B','W','W'},new char[]{'B','W','B'}};
        System.out.println("res = " + canMakeSquare(grid));
    }

    public boolean canMakeSquare(char[][] grid) {
        int[][] d = {new int[]{0,0}, new int[]{0,1}, new int[]{1,0}, new int[]{1,1}};
        for (int i = 0; i < d.length; i++) {
            int[] count = new int[2];
            int a = d[i][0];
            int b = d[i][1];
            count[grid[a][b] & 1]++;
            count[grid[a+1][b] & 1]++;
            count[grid[a][b+1] & 1]++;
            count[grid[a+1][b+1] & 1]++;
            if(count[0] != 2) {
                return true;
            }
        }
        return false;
    }
}


