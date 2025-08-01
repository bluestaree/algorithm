package com.leetcode._2025_7;

import org.junit.Test;


/**
 * 1290. 二进制链表转整数
 *
 * @author DHW
 * @date 2025/7/14 8: 42
 * @Version 1.0
 */
public class ProblemsNo1290 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1);
        System.out.println("res = " + getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head != null) {
            res = res << 1 | head.val;
            head = head.next;
        }
        return res;
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

