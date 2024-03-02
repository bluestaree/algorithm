package com.leetcode._2024_2;

import org.junit.Test;

import java.util.*;


/**
 * 102. 二叉树的层序遍历
 *
 * @author DHW
 * @date 2024/2/14 12:10
 * @Version 1.0
*/
public class ProblemsNo102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> s = new ArrayList<>();
        if(root == null) {
            return s;
        }
        Deque<TreeNode> deque = new ArrayDeque();
        deque.offer(root);
        for (int n = 1; !deque.isEmpty() ; n++) {
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
            if(n % 2 == 0) {
                Collections.reverse(list);
            }
            s.add(list);
        }
        return s;
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

