package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 36. 有效的数独
 *
 * @author DHW
 * @date 2025/8/30 10: 38
 * @Version 1.0
*/
public class ProblemsNo36 {

    @Test
    public void solution() {
        char[][] board = new char[][]{new char[]{'5','3','.','.','7','.','.','.','.'},new char[]{'6','.','.','1','9','5','.','.','.'},new char[]{'.','9','8','.','.','.','.','6','.'},new char[]{'8','.','.','.','6','.','.','.','3'}
                ,new char[]{'4','.','.','8','.','3','.','.','1'},new char[]{'7','.','.','.','2','.','.','.','6'},new char[]{'.','6','.','.','.','.','2','8','.'},new char[]{'.','.','.','4','1','9','.','.','5'},new char[]{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("res = " + isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        List<int[]> rows = new ArrayList<int[]>();
        List<int[]> cols = new ArrayList<int[]>();
        List<int[]> block = new ArrayList<int[]>();
        for (int i = 0; i < 9; i++) {
            rows.add(new int[10]);
            cols.add(new int[10]);
            block.add(new int[10]);
        }
        for (int i = 0; i < board.length; i++) {
            int[] row = rows.get(i);
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int[] col = cols.get(j);
                int t = i / 3 * 3 + j / 3;
                int[] b = block.get(t);
                row[num]++;
                col[num]++;
                b[num]++;
                if(row[num] > 1 || col[num] > 1 || b[num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

