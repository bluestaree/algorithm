package com.itheima.week9.avl_tree_1;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-07 16:10
 **/
public class AvlTreeTest1382 {
    @Test
    public void test1382() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        balanceBST(root);
    }
    
    TreeNode root = null;
    
    /**
     * 这个不行,因为TreeNode的子类AvlNode识别不了
     *
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        //需要先进行中序遍历,把root加入到队列中去
        Queue<Integer> queue = new LinkedList<>();
        inOrder(root, queue);
        
        //需要构造出一个avl树,通过queue构造
        while (!queue.isEmpty()) {
            int i = queue.poll();
            //需要构造一棵树 ,通过中间的二分法,中间的为根节点,小的为左边,大的为右边
        }
        
        //
        return this.root;
    }
    
    private void inOrder(TreeNode node, Queue<Integer> queue) {
        //终止条件
        if (node == null) {
            return;
        }
        
        //当前层处理
        inOrder(node.left, queue);
        queue.add(node.val);
        inOrder(node.right, queue);
        
    }
    
}
