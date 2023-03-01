package com.leetcode._2023_2;

import org.junit.Test;


/**
 * 2331. 计算布尔二叉树的值
 *
 * @author DHW
 * @date 2023/2/6 13:51
 * @Version 1.0
*/
public class ProblemsNo2331 {

    @Test
    public void solution() {

        TreeNode h4 = new TreeNode(4);
        TreeNode h3 = new TreeNode(3);
        TreeNode h2 = new TreeNode(2);
        TreeNode h1 = new TreeNode(1);
        TreeNode head = new TreeNode(0);
    }

    public boolean evaluateTree(TreeNode root) {
        if(root.val <= 1) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 3 ? left && right : left || right;
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
