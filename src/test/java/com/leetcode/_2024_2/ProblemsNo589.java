package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 589. N 叉树的前序遍历
 *
 * @author DHW
 * @date 2024/2/18 9:05
 * @Version 1.0
*/
public class ProblemsNo589 {

    @Test
    public void solution() {
        Node root = new Node(1);
        System.out.println("res = " + preorder(root));
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

