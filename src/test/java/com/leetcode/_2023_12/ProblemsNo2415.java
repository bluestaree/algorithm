package com.leetcode._2023_12;

import org.junit.Test;

import java.util.*;


/**
 * 2415. 反转二叉树的奇数层
 *
 * @author DHW
 * @date 2023/12/15 9:30
 * @Version 1.0
*/
public class ProblemsNo2415 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1);
        System.out.println("res = " + reverseOddLevels(root));
    }

    private HashMap<Integer, List<TreeNode>> map;

    public TreeNode reverseOddLevels(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 0);
        for (List<TreeNode> value : map.values()) {
            int left = 0;
            int right = value.size() - 1;
            while(right > left) {
                TreeNode a = value.get(right);
                TreeNode b = value.get(left);
                int temp = a.val;
                a.val = b.val;
                b.val = temp;
                right--;
                left++;
            }
        }
        return root;
    }

    private void dfs(TreeNode node, int deep) {
        if(node == null) {
            return;
        }
        if(deep % 2 == 1) {
            List<TreeNode> nodes = map.getOrDefault(deep, new ArrayList<>());
            nodes.add(node);
            map.put(deep, nodes);
        }
        deep++;
        dfs(node.left, deep);
        dfs(node.right, deep);
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

