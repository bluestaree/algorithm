package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 94. 二叉树的中序遍历
 *
 * @author DHW
 * @date 2024/2/10 18:39
 * @Version 1.0
*/
public class ProblemsNo94 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + inorderTraversal(head));
    }

    private List<Integer> s = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return s;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        s.add(node.val);
        dfs(node.right);
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

