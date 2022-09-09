package com.itheima.week8.advanced_search;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-28 11:11
 **/
public class Test1091 {
    @Test
    public void test1091二进制矩阵中的最短路径() {
        shortestPathBinaryMatrix(null);
    }
    
    //数组
    int[][] direction = new int[][]{
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };
    int n;
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //    初始值
        if (grid == null || grid.length == 0) {
            return -1;
        }
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        //广度优先
        Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.v));
        queue.offer(new Vertex(1, 0, 0));
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            //当前层
            int row = vertex.row;
            int col = vertex.col;
            int step = grid[row][col];
            //是否结束
            if (row == n - 1 && col == n - 1) {
                return step;
            }
            //下一层元素
            for (int[] ints : direction) {
                int row1 = ints[0] + row;
                int col1 = ints[1] + col;
                int step1 = step + 1;
                
                //边界内
                if (!isValid(row1, col1)) {
                    continue;
                }
                //grid 不为1 
                //    满足要求的
                if (grid[row1][col1] == 0) {
                    grid[row1][col1] = step1;
                    queue.add(new Vertex(step1, row1, col1));
                }
                //
                if (grid[row1][col1] > step1) {
                    grid[row1][col1] = step1;
                    queue.add(new Vertex(step1, row1, col1));
                }
            }
        }
        return -1;
    }
    
    private boolean isValid(int row1, int col1) {
        return row1 >= 0 && col1 >= 0 && row1 < n && col1 < n;
    }
    
    class Vertex {
        int v;
        int row;
        int col;
        
        public Vertex(int step, int row, int col) {
            int diff = Math.max(n - row - 1, n - col - 1);
            this.row = row;
            this.col = col;
            this.v = step + diff;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Vertex vertex = (Vertex) o;
            
            if (row != vertex.row) return false;
            return col == vertex.col;
        }
        
        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }
}
