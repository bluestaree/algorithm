package com.leetcode._2024_2;

import org.junit.Test;

import java.util.*;


/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author DHW
 * @date 2024/2/25 15:11
 * @Version 1.0
*/
public class ProblemsNo235 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        head.left = node1;
        TreeNode node2 = new TreeNode(2);
        head.right = node2;
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + lowestCommonAncestor(head, node1, node2));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
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

