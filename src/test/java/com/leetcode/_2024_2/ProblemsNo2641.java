package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2641. 二叉树的堂兄弟节点 II
 *
 * @author DHW
 * @date 2024/2/7 11:32
 * @Version 1.0
*/
public class ProblemsNo2641 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + replaceValueInTree(head));
    }

    private List<Integer> s = new ArrayList<>();

    public TreeNode replaceValueInTree(TreeNode root) {
        dfs1(root, 0);
        root.val = 0;
        dfs2(root, 0);
        return root;
    }

    private void dfs1(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (s.size() <= depth) {
            s.add(0);
        }
        s.set(depth, s.get(depth) + root.val);
        dfs1(root.left, depth + 1);
        dfs1(root.right, depth + 1);
    }

    private void dfs2(TreeNode root, int depth) {
        int l = root.left == null ? 0 : root.left.val;
        int r = root.right == null ? 0 : root.right.val;
        int sub = l + r;
        ++depth;
        if (root.left != null) {
            root.left.val = s.get(depth) - sub;
            dfs2(root.left, depth);
        }
        if (root.right != null) {
            root.right.val = s.get(depth) - sub;
            dfs2(root.right, depth);
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

