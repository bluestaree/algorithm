package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 143. 重排链表
 *
 * @author DHW
 * @date 2023/7/31 9:05
 * @Version 1.0
*/
public class ProblemsNo143 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head.next = node11;
        node11.next = node12;
        node12.next = node13;
        reorderList(head);
        System.out.println("res = " + head);
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode cur = head.next;
        while(cur != null) {
            deque.addLast(cur);
            cur = cur.next;
        }

        boolean mark = false;
        cur = head;
        while(!deque.isEmpty()) {
            if(mark) {
                cur.next = deque.pollFirst();
            } else {
                cur.next = deque.pollLast();
            }
            mark = !mark;
            cur = cur.next;
        }
        cur.next = null;
    }

    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
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
