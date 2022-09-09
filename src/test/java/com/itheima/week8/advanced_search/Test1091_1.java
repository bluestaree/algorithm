package com.itheima.week8.advanced_search;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-07 07:57
 **/
public class Test1091_1 {
    @Test
    public void test1091二进制矩阵中的最短路径() {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    
    int n;
    
    //
    int[][] direction = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            //
            {-1, 1},
            {1, 1},
            {-1, -1},
            {1, -1},
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        //初始值判断
        n = grid.length;
        if (!(grid[0][0] == 0 && grid[n - 1][n - 1] == 0)) {
            return -1;
        }
        
        //优先级队列,类似于贪心算法
        PriorityQueue<Position> queue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return (o1.f - o2.f);
            }
        });
        Position end = new Position(n - 1, n - 1, 1);
        queue.add(end);
        grid[n - 1][n - 1] = 1;
        
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int i0 = pos.i;
            int j0 = pos.j;
            int step = grid[i0][j0];
            //看看是否到终点了
            if (i0 == 0 && j0 == 0) {
                return step;
            }
            for (int[] dir : direction) {
                int i = dir[0] + i0;
                int j = dir[1] + j0;
                if ((i >= 0 && i < n && j >= 0 && j < n)) {
                    if (grid[i][j] == 0 || grid[i][j] > step + 1) {
                        grid[i][j] = step + 1;
                        Position next = new Position(i, j, step + 1);
                        queue.add(next);
                    }
                }
            }
        }
        //
        return -1;
    }
    
    static class Position {
        int i;
        int j;
        int f;
        
        public Position(int i, int j, int step) {
            this.i = i;
            this.j = j;
            //需要把距离终点更近的节点放到前面
            int max = Math.max(i, j);
            f = max + step;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Position position = (Position) o;
            
            if (i != position.i) return false;
            return j == position.j;
        }
        
        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
