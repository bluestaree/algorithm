package com.leetcode._2024_2;

import com.sun.xml.internal.fastinfoset.util.ValueArray;
import org.junit.Test;

import java.util.*;


/**
 * 2583. 二叉树中的第 K 大层和
 *
 * @author DHW
 * @date 2024/2/23 9:06
 * @Version 1.0
*/
public class ProblemsNo2583 {

    @Test
    public void solution() {
        TreeNode node = new TreeNode(1);
        int k = 2;
        System.out.println("res = " + kthLargestLevelSum(node, k));
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Long> list = new ArrayList();
        while (!deque.isEmpty()){
            long t = 0;
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                t += node.val;
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
            list.add(t);
        }
        if(list.size() < k) {
            return -1;
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(k-1);
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

