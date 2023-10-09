package com.leetcode._2023_9;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 1123. 最深叶节点的最近公共祖先
 *
 * @author DHW
 * @date 2023/9/6 9:39
 * @Version 1.0
 */
public class ProblemsNo1123 {

    @Test
    public void solution() {
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<Integer, TreeNode> res = dfs(root);
        return res.getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode node) {
        if(node == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> deepLeft = dfs(node.left);
        Pair<Integer, TreeNode> deepRight = dfs(node.right);
        if(deepLeft.getKey() > deepRight.getKey()) {
            return new Pair<>(deepLeft.getKey() + 1, deepLeft.getValue());
        }
        if(deepLeft.getKey() < deepRight.getKey()) {
            return new Pair<>(deepRight.getKey() + 1, deepRight.getValue());
        }
        return new Pair<>(deepLeft.getKey() + 1, node);
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
