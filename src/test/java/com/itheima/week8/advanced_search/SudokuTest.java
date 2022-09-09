package com.itheima.week8.advanced_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-06 10:11
 **/
public class SudokuTest {
    
    @Test
    public void test数独补全() {
        char[][] board;
        board = new char[][]{
                //0     1   2   3    4    5    6     7    8
                {'.', '.', '.', '4', '5', '.', '1', '.', '.'}
                , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'.', '7', '2', '.', '.', '.', '.', '.', '9'}
                //0     1   2   3    4    5    6     7    8
                , {'.', '.', '.', '8', '.', '.', '.', '.', '.'}
                , {'4', '.', '.', '.', '.', '.', '5', '1', '.'}
                , {'.', '6', '.', '.', '.', '7', '.', '.', '.'}
                //0     1   2   3    4    5    6     7    8
                , {'.', '.', '.', '.', '.', '.', '.', '9', '.'}
                , {'.', '.', '.', '.', '.', '.', '2', '.', '7'}
                , {'5', '8', '.', '.', '.', '.', '.', '.', '.'}
        };
        
        isValidSudoku1(board);
    }
    
    //把这里的list+set,换成boolean[][]数组,第一列i,第二列放存储的字符数字,boolean存储是否已经有了
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] bulks = new boolean[9][9];
    List<int[]> list = new ArrayList<>();
    int count;
    
    public void isValidSudoku1(char[][] board) {
        //   初始值判断  
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        //需要双层循环确认初始条件,每个剩下了多少的值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    list.add(new int[]{i, j});
                } else {
                    rows[i][c - '1'] = true;
                    cols[j][c - '1'] = true;
                    bulks[(i / 3) * 3 + j / 3][c - '1'] = true;
                }
            }
        }
        count = list.size();
        dfs37(0, board);
        
    }
    
    int total = 1;
    
    private void dfs37(int depth, char[][] board) {
        
        //终止条件,就是全部都是
        if (depth == count) {
            System.out.println("==========方案" + total++ + "========");
            for (char[] chars : board) {
                System.out.println(Arrays.toString(chars));
            }
            return;
        }
        int[] pos = list.get(depth);
        int i = pos[0];
        int j = pos[1];
        
        //需要进行递归了,是深度优先递归哦
        for (int val = 0; val < 9; val++) {
            
            //剪枝,已经有了,就跳过
            if (rows[i][val] || cols[j][val] || bulks[(i / 3) * 3 + j / 3][val]) {
                continue;
            }
            //回溯
            
            //选择 
            rows[i][val] = true;
            cols[j][val] = true;
            bulks[(i / 3) * 3 + j / 3][val] = true;
            board[i][j] = (char) (val + '1');
            
            //下一层处理
            // 找到下一个需要填空的点
            dfs37(depth + 1, board);
            
            //撤销 
            
            rows[i][val] = false;
            cols[j][val] = false;
            bulks[(i / 3) * 3 + j / 3][val] = false;
            board[i][j] = '.';
        }
    }
    
}
