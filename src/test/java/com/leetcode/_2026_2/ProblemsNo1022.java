package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 1022. 从根到叶的二进制数之和
 *
 * @author DHW
 * @date 2026/2/24 8:44
 * @Version 1.0
*/
public class ProblemsNo1022 {

    @Test
    public void solution() {
    }

    public int sumRootToLeaf(TreeNode root) {
         return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return num * 2 + root.val;
        return dfs(root.left, num * 2 + root.val) + dfs(root.right, num * 2 + root.val);
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
