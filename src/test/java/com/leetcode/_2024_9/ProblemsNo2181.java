package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 2181. 合并零之间的节点
 *
 * @author DHW
 * @date 2024/9/9 8:45
 * @Version 1.0
*/
public class ProblemsNo2181 {

    @Test
    public void solution() {
        ListNode tail = new ListNode(0);
        ListNode node3 = new ListNode(3, tail);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);
        System.out.println("res = " + mergeNodes(head));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode();
        ListNode pre = root;
        ListNode node = head.next;
        int num = head.val;
        while(node != null) {
            if(node.val == 0) {
                node.val = num;
                pre.next = node;
                pre = node;
                num = 0;
            } else {
                num += node.val;
            }
            node = node.next;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

