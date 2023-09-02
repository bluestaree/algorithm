package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 24. 两两交换链表中的节点
 *
 * @author DHW
 * @date 2023/8/6 11:22
 * @Version 1.0
*/
public class ProblemsNo24 {

    @Test
    public void solution() {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        node1.next = node11;
        node11.next = node12;
        node12.next = node13;
        ListNode listNode = swapPairs(node1);
        System.out.println("res = " + listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode temp = res;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return res.next;
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
