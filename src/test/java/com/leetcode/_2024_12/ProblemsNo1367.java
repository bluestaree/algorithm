package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1367. 二叉树中的链表
 *
 * @author DHW
 * @date 2024/12/15 12: 31
 * @Version 1.0
*/
public class ProblemsNo1367 {

    @Test
    public void solution() {
        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(8)));
        TreeNode root = new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null))
                                        , new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null));
        System.out.println("res = " + isSubPath(listNode, root));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }
        return  dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode cur, TreeNode node) {
        if(cur == null) {
            return true;
        }
        if (node == null || cur.val != node.val) {
            return false;
        }
        return dfs(cur.next, node.left) || dfs(cur.next, node.right);
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

