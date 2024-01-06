package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1457. 二叉树中的伪回文路径
 *
 * @author DHW
 * @date 2023/11/25 10:58
 * @Version 1.0
 */
public class ProblemsNo1457 {

    @Test
    public void solution() {
        TreeNode node = new TreeNode(1);
        System.out.println("minimum = " + pseudoPalindromicPaths(node));
    }

    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int val = root.val;
        int num = 0 ^ (1 << val);
        if(root.left == null && root.right == null) {
            return 1;
        }
        dfs(root.left, num);
        dfs(root.right, num);
        return res;
    }

    private void dfs(TreeNode node, int num) {
        if(node == null) {
            return;
        }
        num ^= (1 << node.val);
        if(node.left == null && node.right == null) {
            checkNum(num);
            return;
        }
        dfs(node.left, num);
        dfs(node.right, num);
    }

    private void checkNum(int num) {
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            if((num >> i & 1) == 1) {
                count++;
            }
        }
        if(count <= 1) {
            res++;
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