package com.itheima.week6.dfs_bfs;

import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: algo_pro
 * @description: 深度优先dfs和广度优先bfs算法
 * @author: zhanghz001
 * @create: 2020-12-10 09:55
 **/
public class BfsAndDfsRecursion {
    
    @Test
    public void test102二叉树的层序遍历() {
        levelOrder(null);
    }
    
    /**
     * 广度优先算法实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //初值判断    
        if (root == null) {
            return res;
        }
        //不为null,就进行广度优先bfs的搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        
        //
        return res;
    }
    
    /**
     * 深度优先算法实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        //不做这个了,用在其他地方上
        return null;
    }
    
    @Test
    public void test104二叉树的最大深度() {
        maxDepth(null);
    }
    
    /**
     * 深度优先算法实现
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //深度优先
        //终止条件
        if (root == null) {
            return 0;
        }
        //其他
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        
    }
    
    @Test
    public void test515在每个树行中找最大值() {
        largestValues(null);
    }
    
    /**
     * 广度优先算法实现
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        //初始值判断
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    {
                        queue.add(node.left);
                    }
                }
            }
            res.add(max);
        }
        return res;
    }
    
    @Test
    public void test200岛屿数量() {
        numIslands(null);
    }
    
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},};
    
    int colLen;
    int rowLen;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        
        //初始值判断
        if (grid == null || (rowLen = grid.length) == 0
                || (colLen = grid[0].length) == 0) {
            return 0;
        }
        boolean[][] used = new boolean[rowLen][colLen];
        
        //需要进行循环,循环中寻找是否有岛屿
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                //使用过
                if (used[i][j]) {
                    continue;
                }
                //寻找island
                used[i][j] = true;
                if (grid[i][j] == '1') {
                    count++;
                    //需要把这个岛屿dfs深度扩散出去
                    dfs200(i, j, used, grid);
                }
            }
        }
        return count;
    }
    
    private void dfs200(int i1, int j1, boolean[][] used, char[][] grid) {
        for (int[] rowCol : direction) {
            int j = j1 + rowCol[1];
            int i = i1 + rowCol[0];
            //边界内
            if (i >= 0 && i < rowLen
                    && j >= 0 && j < colLen) {
                //剪枝
                //使用过
                if (used[i][j]) {
                    continue;
                }
                //没有使用过
                used[i][j] = true;
                if (grid[i][j] == '1') {
                    //继续递归
                    dfs200(i, j, used, grid);
                }
            }
        }
    }
    
    @Test
    public void test529扫雷游戏() {
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};
        updateBoard(board, click);
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        //初始值判断
        if (board == null) {
            return null;
        }
        if (click == null || click.length != 2) {
            return board;
        }
        rows529 = board.length;
        if (rows529 == 0) {
            return new char[0][0];
        }
        cols529 = board[0].length;
        if (cols529 == 0) {
            return new char[0][0];
        }
        //点击位置不在board中
        int x = click[0];
        int y = click[1];
        if (x >= rows529 || y >= cols529) {
            return board;
        }
        //返回值 
        //需要做深度优先的递归
        char c = board[x][y];
        if (c == 'M') {
            //如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
            board[x][y] = 'X';
        } else if (c == 'E') {
            // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），
            // 并且所有和其相邻的未挖出方块都应该被递归地揭露。
            // 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
            dfsBoard(board, x, y);
        }
        // 如果在此次点击中，若无更多方块可被揭露，则返回面板。
        
        return board;
    }
    
    private void dfsBoard(char[][] board, int x, int y) {
        //terminal
        if (board[x][y] != 'E') {
            return;
        }
        
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x1 = x + direction[i][0];
            int y1 = y + direction[i][1];
            boolean inBoard = inBoard(x1, y1);
            if (inBoard && board[x1][y1] == 'M') {
                count++;
            }
        }
        if (count == 0) {
            board[x][y] = 'B';
            // System.out.println("x: " + x + " y: " + y + " board: " + board[x][y]);
            for (int i = 0; i < 8; i++) {
                //深度往下
                int x1 = x + direction[i][0];
                int y1 = y + direction[i][1];
                boolean inBoard = inBoard(x1, y1);
                if (inBoard) {
                    dfsBoard(board, x1, y1);
                }
            }
        } else {
            board[x][y] = (char) ('0' + count);
            // System.out.println("x: " + x + " y: " + y + " board: " + board[x][y]);
        }
    }
    
    int cols529 = 0;
    int rows529 = 0;
    
    private boolean inBoard(int x, int y) {
        return x >= 0 && x < rows529 && y >= 0 && y < cols529;
    }
    
    @Test
    public void test36有效的数独() {
        char[][] board;
        board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        
        // board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
        //         , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
        //         , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
        //         , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
        //         , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
        //         , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
        //         , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
        //         , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
        //         , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        board = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }
    
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
