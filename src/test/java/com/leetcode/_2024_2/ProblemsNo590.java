package com.leetcode._2024_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 590. N 叉树的后序遍历
 *
 * @author DHW
 * @date 2024/2/19 9:04
 * @Version 1.0
*/
public class ProblemsNo590 {

    @Test
    public void solution() {
        Node root = new Node(1);
        System.out.println("res = " + postorder(root));
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if(root == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child);
        }
        res.add(root.val);
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

