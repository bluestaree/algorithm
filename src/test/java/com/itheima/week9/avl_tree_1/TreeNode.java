package com.itheima.week9.avl_tree_1;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    /**
     * 我们取第一种高度定义:从根节点到最深节点的最长路径的节点数
     * 故：空树高度记为0，叶子节点高度记为1
     */
    int height = 1;
    
    public TreeNode(int val) {
        this.val = val;
    }
}
