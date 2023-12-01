package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author DHW
 * @date 2023/11/3 10:11
 * @Version 1.0
 */
public class ProblemsNo117 {

    @Test
    public void solution() {
        Node root = new Node(1);
        System.out.println("minimum = " + connect(root));
    }

    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);
        while(list.size() != 0) {
            ArrayList<Node> nextFlood = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if(node == null) {
                    continue;
                }
                Node left = node.left;
                Node right = node.right;
                if(left != null) {
                    nextFlood.add(left);
                }
                if(right != null) {
                    nextFlood.add(right);
                }
                if(i != 0 && list.get(i-1) != null) {
                    list.get(i-1).next = node;
                }
            }
            list = nextFlood;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}