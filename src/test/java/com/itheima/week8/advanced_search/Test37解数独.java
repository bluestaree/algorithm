package com.itheima.week8.advanced_search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-28 09:23
 **/
public class Test37解数独 {
    @Test
    public void test37解数独() {
        solveSudoku(null);
    }
    
    HashSet<Character>[] rowSet = new HashSet[9];
    HashSet<Character>[] colSet = new HashSet[9];
    HashSet<Character>[] blockSet = new HashSet[9];
    
    List<int[]> list = new ArrayList<>();
    
    public void solveSudoku(char[][] board) {
        //    不用初始值判断
        //
        //把所有的初始值都放入其中
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            blockSet[i] = new HashSet<>();
            
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char temp = board[row][col];
                if (temp == '.') {
                    list.add(new int[]{row, col});
                } else {
                    int blockIdx = (row / 3) * 3 + col / 3;
                    rowSet[row].add(temp);
                    colSet[col].add(temp);
                    blockSet[blockIdx].add(temp);
                }
            }
        }
        //对list进行dfs,找到一个可以组成数独的矩阵 
        int depth = 0;
        dfs(board, depth);
    }
    
    private boolean dfs(char[][] board, int depth) {
        //    递归终止条件
        if (list.size() == depth) {
            return true;
        }
        
        int[] grid = list.get(depth);
        int row = grid[0];
        int col = grid[1];
        int blockIdx = (row / 3) * 3 + col / 3;
        //    当前层处理
        for (char i = '1'; i <= '9'; i++) {
            if (rowSet[row].contains(i)) {
                continue;
            }
            if (colSet[col].contains(i)) {
                continue;
            }
            if (blockSet[blockIdx].contains(i)) {
                continue;
            }
            
            //说明可以找到一个字符放到当前位置
            board[row][col] = i;
            rowSet[row].add(i);
            colSet[col].add(i);
            blockSet[blockIdx].add(i);
            
            //到下一层
            boolean flag = dfs(board, depth + 1);
            //下一层成功了,说明当前填充的是对的
            if (flag) {
                return true;
            }
            //没有填充成功,就回溯
            //复位
            board[row][col] = '.';
            rowSet[row].remove(i);
            colSet[col].remove(i);
            blockSet[blockIdx].remove(i);
        }
        return false;
    }
}
 
