package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 445. 两数相加2
 *
 * @author DHW
 * @date 2023/7/2 11:42
 * @Version 1.0
*/
public class ProblemsNo445 {

    @Test
    public void solution() {
        ListNode node1 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(3);
        node1.next = node11;
        node11.next = node12;
        ListNode node2 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node22 = new ListNode(4);
        node2.next = node21;
        node21.next = node22;
        ListNode listNode = addTwoNumbers(node1, node2);
        System.out.println("res = " + listNode);
    }

    private ListNode node;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque();
        Deque<Integer> deque2 = new ArrayDeque();
        buildDeque(deque1, l1);
        buildDeque(deque2, l2);
        buildNode(deque1, deque2, new ListNode(), false);
        return node;
    }

    private void buildNode(Deque<Integer> deque1, Deque<Integer> deque2, ListNode listNode, boolean flag) {
        if(deque1.isEmpty() && deque2.isEmpty()) {
            if(flag) {
                node = listNode;
                node.val = 1;
            } else {
                node = listNode.next;
            }
            return;
        }

        Integer i1 = deque1.isEmpty() ? 0 : deque1.poll();
        Integer i2 = deque2.isEmpty() ? 0 : deque2.poll();

        int res = flag ? i1 + i2 + 1 : i1 + i2;
        if(res >= 10) {
            flag = true;
        } else {
            flag = false;
        }
        listNode.val = res % 10;
        ListNode pre = new ListNode();
        pre.next = listNode;
        buildNode(deque1, deque2, pre, flag);
    }

    private void buildDeque(Deque deque, ListNode node) {
        while (true) {
            if(node == null) {
                break;
            }
            deque.push(node.val);
            node = node.next;
        }
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
