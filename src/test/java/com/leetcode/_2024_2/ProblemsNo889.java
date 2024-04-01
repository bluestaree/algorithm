package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 889. 根据前序和后序遍历构造二叉树
 *
 * @author DHW
 * @date 2024/2/22 9:39
 * @Version 1.0
*/
public class ProblemsNo889 {

    @Test
    public void solution() {
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        System.out.println("res = " + constructFromPrePost(preorder, postorder));
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, 0, n, postorder, 0, n);
    }

    private TreeNode dfs(int[] preorder, int i1, int i2, int[] postorder, int j1, int j2) {
        if(i1 == i2) {
           return null;
        }
        if (i1 + 1 == i2) {
            return new TreeNode(preorder[i1]);
        }
        int leftsize = map.get(preorder[i1 + 1]) - j1 + 1;
        TreeNode left = dfs(preorder, i1 + 1, i1 + 1 + leftsize, postorder, j1, j1 + leftsize);
        TreeNode right = dfs(preorder, i1 + 1 + leftsize,i2, postorder, j1 + leftsize, j2 - 1);
        return new TreeNode(preorder[i1], left, right);
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

