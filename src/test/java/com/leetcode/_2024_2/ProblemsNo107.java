package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 107. 二叉树的层序遍历 II
 *
 * @author DHW
 * @date 2024/2/15 14:23
 * @Version 1.0
*/
public class ProblemsNo107 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        head.left = node1;
        TreeNode node2 = new TreeNode(2);
        head.right = node2;
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + levelOrder(head));
    }

    private List<List<Integer>> s = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        Collections.reverse(s);
        return s;
    }

    private void dfs(TreeNode node, int deep) {
        if(node == null) {
            return;
        }
        List<Integer> list;
        if(s.size() > deep) {
            list = s.get(deep);
        } else {
            list = new ArrayList<>();
            s.add(list);
        }
        list.add(node.val);
        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
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

