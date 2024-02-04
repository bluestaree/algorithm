package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * 2487. 从链表中移除节点
 *
 * @author DHW
 * @date 2024/1/3 9:22
 * @Version 1.0
*/
public class ProblemsNo2487 {

    @Test
    public void solution() {
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(13);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(8);
        node3.next = node4;
        System.out.println("res = " + removeNodes(head));
    }

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> s = new ArrayDeque();
        ListNode node = head;
        while (node != null) {
            while(!s.isEmpty() && s.peekLast().val < node.val) {
                s.pollLast();
            }
            if(s.isEmpty()) {
                head = node;
            } else {
                s.peekLast().next = node;
            }
            s.offerLast(node);
            node = node.next;
        }
        return head;
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

