package com.leetcode._2026_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 1161. 最大层内元素和
 *
 * @author DHW
 * @date 2026/1/6 9:44
 * @Version 1.0
*/
public class ProblemsNo1161 {

    @Test
    public void solution() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        System.out.println("res = " + maxLevelSum(head));
    }

    private List<Integer> s = new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int i = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        while (!deque.isEmpty()) {
            i++;
            int size = deque.size();
            int sum = 0;
            for (int j = 0; j < size; j++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
            if(sum > max) {
                ans = i;
                max = sum;
            }
        }
        return ans;
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

