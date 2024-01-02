package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 1038. 从二叉搜索树到更大和树
 *
 * @author DHW
 * @date 2023/12/1 10:27
 * @Version 1.0
*/
public class ProblemsNo1038 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1);
        System.out.println("res = " + bstToGst(root));
    }

    int val;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.right);
        val += node.val;
        node.val = val;
        dfs(node.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

