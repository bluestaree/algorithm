package com.leetcode._2023_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1110. 删点成林
 *
 * @author DHW
 * @date 2023/5/30 9:27
 * @Version 1.0
*/
public class ProblemsNo1110 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        root.left = root1;
        root1.left = root2;
        root1.right = root3;
        int[] to_delete = new int[]{2, 3};
        System.out.println("res = " + delNodes(root, to_delete));
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int[] pos = new int[1001];
        for (int i = 0; i < to_delete.length; i++) {
            pos[to_delete[i]] = 1;
        }

        ArrayList<TreeNode> nodes = new ArrayList<>();
        checkNode(root, pos, nodes, null);

        return nodes;
    }

    private void checkNode(TreeNode node, int[] pos, ArrayList<TreeNode> nodes, TreeNode parent) {
        if(node == null) {
            return;
        }
        TreeNode part = null;
        if(pos[node.val] == 1) {
            if(parent != null) {
                if(parent.right != null && parent.right.val == node.val) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            }
        } else {
            part = node;
            if(parent == null) {
                nodes.add(node);
            }
        }
        checkNode(node.left, pos, nodes, part);
        checkNode(node.right, pos, nodes, part);
    }

//    private void checkNode(TreeNode node, int[] pos, ArrayList<TreeNode> nodes, TreeNode parent) {
//        if(node == null) {
//            return;
//        }
//        if(pos[node.val] == 1) {
//            if(parent.right.val == node.val) {
//                parent.right = null;
//            } else {
//                parent.left = null;
//            }
//            checkNode(node.left, pos, nodes, null);
//            checkNode(node.right, pos, nodes, null);
//            return;
//        }
//        if(parent == null) {
//            nodes.add(node);
//        }
//        checkNode(node.left, pos, nodes, node);
//        checkNode(node.right, pos, nodes, node);
//    }

    class TreeNode {
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
