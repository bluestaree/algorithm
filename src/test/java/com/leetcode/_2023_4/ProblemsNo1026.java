package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 1026. 节点与其祖先之间的最大差值
 *
 * @author DHW
 * @date 2023/4/18 10:08
 * @Version 1.0
*/
public class ProblemsNo1026 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        root.right = node1;
        node1.right = node2;
        node2.left = node3;
        System.out.println("res = " + maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff(root.val, root.val, root.left);
        maxDiff(root.val, root.val, root.right);
        return max;
    }

    public void maxDiff(int maxVal, int minVal, TreeNode current) {
        if(current == null) {
            return;
        }
        if(maxVal < current.val) {
            maxVal = current.val;
        }
        if(minVal > current.val) {
            minVal = current.val;
        }
        maxDiff(maxVal, minVal, current.left);
        maxDiff(maxVal, minVal, current.right);
        max = Math.max(max, Math.abs(maxVal - minVal));
    }

    public int max;

    public class TreeNode {
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
