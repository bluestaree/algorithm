package com.leetcode._2026_6;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 2095. 删除链表的中间节点
 *
 * @author DHW
 * @date 2024/9/9 8:45
 * @Version 1.0
*/
public class ProblemsNo2095 {

    @Test
    public void solution() {
        ListNode tail = new ListNode(0);
        ListNode node3 = new ListNode(3, tail);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);
        System.out.println("res = " + deleteMiddle(head));
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        int n = nodes.size();
        int mid = n / 2;
        nodes.get(mid - 1).next = nodes.get(mid).next;
        return head;
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

