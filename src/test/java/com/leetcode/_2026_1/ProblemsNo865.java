package com.leetcode._2026_1;

import com.leetcode._2022_9.ProblemsNo699;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 865. 具有所有最深节点的最小子树
 *
 * @author DHW
 * @date 2026/1/9 8:45
 * @Version 1.0
*/
public class ProblemsNo865 {

    @Test
    public void solution() {
    }


    TreeNode ans;
    int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int i) {
        if(node == null) {
            maxDepth = Math.max(maxDepth, i);
            return i;
        }
        int dL = dfs(node.left, i + 1);
        int dR  = dfs(node.right, i + 1);
        if(dL == dR && dL == maxDepth) {
            ans = node;
        }
        return Math.max(dL, dR);
    }

    public class TreeNode {
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
