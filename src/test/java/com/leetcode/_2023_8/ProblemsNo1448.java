package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 1448. 统计二叉树中好节点的数目
 *
 * @author DHW
 * @date 2023/8/25 9:07
 * @Version 1.0
*/
public class ProblemsNo1448 {

    @Test
    public void solution() {
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int val) {
        if(node == null) {
            return 0;
        }
        int res = 0;
        if(node.val >= val) {
            res++;
            val = node.val;
        }
        res += countGoodNodes(node.left, val);
        res += countGoodNodes(node.right, val);
        return res;
    }

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
