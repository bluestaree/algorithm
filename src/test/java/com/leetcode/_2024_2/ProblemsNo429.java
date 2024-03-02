package com.leetcode._2024_2;

import org.junit.Test;

import java.util.*;


/**
 * 429. N叉树的层序遍历
 *
 * @author DHW
 * @date 2024/2/17 15:54
 * @Version 1.0
*/
public class ProblemsNo429 {

    @Test
    public void solution() {
        Node node = new Node(1);
        System.out.println("res = " + levelOrder(node));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> s = new ArrayList<>();
        if(root == null) {
            return s;
        }
        Deque<Node> deque = new ArrayDeque();
        deque.offer(root);
        while(!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                Node node = deque.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    deque.offer(child);
                }
            }
            s.add(list);
        }
        return s;
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

