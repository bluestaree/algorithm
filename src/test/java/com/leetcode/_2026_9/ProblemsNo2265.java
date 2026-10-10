package com.leetcode._2026_9;

import org.junit.Test;


/**
 * 2265. 统计值等于子树平均值的节点数
 *
 * @author DHW
 * @date 2026/9/10 8:57
 * @Version 1.0
*/
public class ProblemsNo2265 {

    @Test
    public void solution() {
        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(6);
        node2.right = node5;
        System.out.println("res = " + averageOfSubtree(node));
    }

    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[2];
        }
        int[] arr = new int[2];
        int[] al = dfs(node.left);
        int[] ar = dfs(node.right);
        arr[0] = al[0] + ar[0] + node.val;
        arr[1] = al[1] + ar[1] + 1;
        if(arr[0] / arr[1] ==  node.val) {
            ans++;
        }
        return arr;
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

