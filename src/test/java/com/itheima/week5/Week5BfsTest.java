package com.itheima.week5;

import com.itheima.week4.binary_tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-09-19 17:19
 **/
public class Week5BfsTest {
    @Test
    public void test111二叉树的最小深度() {
        minDepth(null);
    }
    
    int min = Integer.MAX_VALUE;
    
    /**
     * 使用递归的方式处理,通过剪枝
     *
     * @param curr
     * @return
     */
    public int minDepth2(TreeNode curr) {
        //初始值判断
        if (curr == null) {
            return 0;
        }
        //使用递归
        //终止条件
        recursion(curr, 0);
        return min;
    }
    
    private void recursion(TreeNode curr, int depth) {
        
        //剪枝
        if (depth >= min) {
            return;
        }
        //终止条件
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            //叶子节点
            depth++;
            min = depth;
            return;
        }
        
        //当前层循环
        depth++;
        recursion(curr.left, depth);
        recursion(curr.right, depth);
    }
    
    /**
     * 广度优先搜索
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //初始化条件
        if (root == null) {
            return 0;
        }
        //广度优先实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //需要进行广度优先
                TreeNode node = queue.poll();
                if (node.right == null && node.left == null) {
                    return depth;
                } else if (node.right != null && node.left == null) {
                    //右边
                    queue.offer(node.right);
                } else if (node.right == null && node.left != null) {
                    //左边
                    queue.offer(node.left);
                } else {
                    //两边
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
    
}
