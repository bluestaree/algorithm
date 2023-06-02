package com.leetcode._2023_5;

import org.junit.Test;


/**
 * 1080. 根到叶路径上的不足节点
 *
 * @author DHW
 * @date 2023/5/22 9:32
 * @Version 1.0
*/
public class ProblemsNo1080 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1);
        int limit = 1;
        System.out.println("res = " + sufficientSubset(root, limit));
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean b = checkSumValue(root, 0, limit);
        return b ? root : null;
    }

    private boolean checkSumValue(TreeNode node, int sum, int limit) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }
        boolean haveSufficientLeft = checkSumValue(node.left, sum + node.val, limit);
        boolean haveSufficientRight = checkSumValue(node.right, sum + node.val, limit);
        if (!haveSufficientLeft) {
            node.left = null;
        }
        if (!haveSufficientRight) {
            node.right = null;
        }
        return haveSufficientLeft || haveSufficientRight;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
