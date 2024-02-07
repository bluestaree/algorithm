package com.leetcode._2024_1;

import org.junit.Test;
import org.w3c.dom.NodeList;


/**
 * 2807. 在链表中插入最大公约数
 *
 * @author DHW
 * @date 2024/1/6 12:16
 * @Version 1.0
*/
public class ProblemsNo2807 {

    @Test
    public void solution() {
        ListNode head = new ListNode(18);
        ListNode node1 = new ListNode(6);
        head.next = node1;
        ListNode node2 = new ListNode(10);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        System.out.println("res = " + insertGreatestCommonDivisors(head));
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pre = head;
        ListNode next = head.next;
        while(next != null) {
            ListNode cur = new ListNode(getNum(pre.val, next.val));
            pre.next = cur;
            cur.next = next;
            pre = next;
            next = next.next;
        }
        return head;
}

    private int getNum(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getNum(b, a % b);
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

