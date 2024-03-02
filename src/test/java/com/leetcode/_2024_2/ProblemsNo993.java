package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author DHW
 * @date 2024/2/8 12:20
 * @Version 1.0
*/
public class ProblemsNo993 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + isCousins(head, 0, 1));
    }

    private List<int[]> list = new ArrayList<>();
    int a = 0;
    int b = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y) {
            return false;
        }
        a = x;
        b = y;
        dfs(root, null, 0);
        return list.get(0)[0] != list.get(1)[0] && list.get(0)[1] == list.get(1)[1];
    }

    private void dfs(TreeNode node, TreeNode parent, int deep) {
        if(node.val == a || node.val == b) {
            list.add(new int[]{parent.val, deep});
            if(list.size() == 2) {
                return;
            }
        }
        if(node.left != null) {
            dfs(node.left, node, deep + 1);
        }
        if(node.right != null) {
            dfs(node.right, node, deep + 1);
        }
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

