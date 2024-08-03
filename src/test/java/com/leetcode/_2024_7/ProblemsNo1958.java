package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1958. 检查操作是否合法
 *
 * @author DHW
 * @date 2024/7/7 11:15
 * @Version 1.0
*/
public class ProblemsNo1958 {

    @Test
    public void solution() {
        char[][] board = new char[][]{new char[]{0,1,10},new char[]{1,2,15},new char[]{0,3,10}};
        int rMove =  1;
        int cMove = 1;
        char color = 'B';
        System.out.println("res = " + checkMove(board, rMove, cMove, color));
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] ds = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}, new int[]{1, 1}, new int[]{1, -1}, new int[]{-1, -1}, new int[]{-1, 1}};
        for (int[] d : ds) {
            int a = rMove + d[0];
            int b = cMove + d[1];
            if(a < 0 || a >= 8 || b < 0 || b >= 8 || board[a][b] == color|| board[a][b] == '.') {
                continue;
            }
            while(true) {
                a = a + d[0];
                b = b + d[1];
                if(a < 0 || a >= 8 || b < 0 || b >= 8 || board[a][b] == '.') {
                    break;
                }
                if(board[a][b] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}

