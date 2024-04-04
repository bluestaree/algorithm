package com.leetcode._2024_3;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * @author DHW
 * @date 2024/3/12 9:39
 * @Version 1.0
*/
public class ProblemsNo1261 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(-1);
        root.right = node1;
        FindElements obj = new FindElements(root);
        boolean param_1 = obj.find(1);
        System.out.println("param_1 = " + param_1);
    }

    class FindElements {
        private HashSet set =  new HashSet<Integer>();

        public FindElements(TreeNode root) {
            root.val = 0;
            dfs(root, root.val);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void dfs(TreeNode root, int val) {
            if(root == null) {
                return;
            }
            set.add(val);
            dfs(root.left, val * 2 + 1);
            dfs(root.right, val * 2 + 2);
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

