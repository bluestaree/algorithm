package com.leetcode;

import org.junit.Test;


/**
 * 699. 修剪二叉搜索树
 * shift-2d-grid
 *
 * @author DHW
 * @date 2022/9/10 13:02
 * @Version 1.0
*/
public class ProblemsNo699 {

    @Test
    public void solution() {

    }

    TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return root;

        //下面两个if相当于删除不满足要求的节点
        if (root.val < low)
            return trimBST(root.right, low, high);//返回修剪过的右子树。抱有一丝丝期望，希望右子树能够满足要求，因为右子树的值大于当前根节点的值
        if (root.val > high)
            return trimBST(root.left, low, high);//返回修剪过的左子树，抱有一丝丝期望，希望左子树能够满足要求，因为左子树的值小于当前根节点的值

        //处理正常的节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
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
