package com.leetcode._2023_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1222. 可以攻击国王的皇后
 *
 * @author DHW
 * @date 2023/9/14 11:39
 * @Version 1.0
*/
public class ProblemsNo1222 {

    @Test
    public void solution() {
        int[][] queens = new int[][]{new int[]{3,5}, new int[]{2,7}};
        int[] king = new int[]{0,0};
        System.out.println("res = " + queensAttacktheKing(queens, king));
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        boolean[][] grid = new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            grid[queens[i][0]][queens[i][1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i != 0 || j != 0) {
                    int x = king[0] + i;
                    int y = king[1] + j;
                    while(x >= 0 && x < 8 && y >= 0 && y < 8) {
                        if(grid[x][y]) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(x);
                            list.add(y);
                            res.add(list);
                            break;
                        }
                        x += i;
                        y += j;
                    }
                }
            }
        }

        return res;
    }
}
