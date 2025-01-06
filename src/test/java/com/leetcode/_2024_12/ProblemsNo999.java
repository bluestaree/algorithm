package com.leetcode._2024_12;

import org.junit.Test;

import javax.sql.rowset.BaseRowSet;


/**
 * 999. 可以被一步捕获的棋子数
 *
 * @author DHW
 * @date 2024/12/6 8: 53
 * @Version 1.0
*/
public class ProblemsNo999 {

    @Test
    public void solution() {
        char[][] board  = new char[][]{new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','p','.','.','.','.'},
                new char[]{'.','.','.','R','.','.','.','p'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','p','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'},
                new char[]{'.','.','.','.','.','.','.','.'}};
        System.out.println("res = " + numRookCaptures(board));
    }

    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int a = 0;
        int b = 0;
        A:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break A;
                }
            }
        }
        int res = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = a;
            int y = b;
            x += dir[0];
            y += dir[1];
            while(x >= 0 && x < n && y >= 0 && y < n && board[x][y] == '.') {
                x += dir[0];
                y += dir[1];
            }
            if(x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 'p') {
                res++;
            }
        }
        return res;
    }
}

