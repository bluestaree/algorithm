package com.leetcode._2023_7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;


/**
 * 445. 环形链表
 *
 * @author DHW
 * @date 2023/7/29 11:51
 * @Version 1.0
*/
public class ProblemsNo141 {

    @Test
    public void solution() {
        ListNode head = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(3);
        head.next = node11;
        node11.next = node12;
        System.out.println("res = " + hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        while (cur != null){
            if(cur.val > 100000) return true;
            cur.val = 100100;
            cur = cur.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
