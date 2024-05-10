package com.leetcode._2024_4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2385. 感染二叉树需要的总时间
 *
 * @author DHW
 * @date 2024/4/24 8:41
 * @Version 1.0
*/
public class ProblemsNo2385 {

    @Test
    public void solution() {
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4, node1, node2);
        TreeNode node4 = new TreeNode(5, null, node3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(3, node6, node5);
        TreeNode head = new TreeNode(1, node4, node7);
        int start = 3;
        System.out.println("res = " + amountOfTime(head, start));
    }

    TreeNode startNode;
    Map<TreeNode, TreeNode> fa = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        return maxDeep(startNode, startNode);
    }

    private int maxDeep(TreeNode node, TreeNode from) {
        if (node == null) {
            return -1; // 注意这里是 -1，因为 start 的深度为 0
        }
        int res = -1;
        if(node.left != from) {
            res = Math.max(res, maxDeep(node.left, node));
        }
        if(node.right != from) {
            res = Math.max(res, maxDeep(node.right, node));
        }
        if (fa.get(node) != from) {
            res = Math.max(res, maxDeep(fa.get(node), node));
        }
        return res + 1;
    }

    private void dfs(TreeNode node, TreeNode from, int start) {
        if(node == null) {
            return;
        }
        if(node.val == start) {
            startNode = node;
        }
        if(from != null) {
            fa.put(node, from);
        }
        dfs(node.left, node, start);
        dfs(node.right, node, start);
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

