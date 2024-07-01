package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 419. 甲板上的战舰
 *
 * @author DHW
 * @date 2024/6/11 8:38
 * @Version 1.0
*/
public class ProblemsNo419 {

    @Test
    public void solution() {
        char[][] board = new char[][]{new char[]{'X','.','.','X'}};
        System.out.println("res = " + countBattleships(board));
    }

    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'X' && (i == 0 || board[i-1][j] != 'X') && (j == 0 || board[i][j-1] != 'X') ) {
                    res++;
                }
            }
        }
        return res;
    }
}

