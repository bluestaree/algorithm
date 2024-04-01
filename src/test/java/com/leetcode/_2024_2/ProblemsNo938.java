package com.leetcode._2024_2;

import org.junit.Test;

import java.util.*;


/**
 * 938. 二叉搜索树的范围和
 *
 * @author DHW
 * @date 2024/2/26 9:57
 * @Version 1.0
*/
public class ProblemsNo938 {

    @Test
    public void solution() {
        TreeNode node = new TreeNode(1);
        int low = 2;
        int high = 5;
        System.out.println("res = " + rangeSumBST(node, low, high));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        if (x > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (x < low) {
            return rangeSumBST(root.right, low, high);
        }
        return x + rangeSumBST(root.left, low, high) +
                rangeSumBST(root.right, low, high);
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

