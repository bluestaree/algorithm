package com.leetcode._2023_7;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;


/**
 * 142. 环形链表 II
 *
 * @author DHW
 * @date 2023/7/30 9:33
 * @Version 1.0
*/
public class ProblemsNo142 {

    @Test
    public void solution() {
        ListNode head = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(3);
        head.next = node11;
        node11.next = node12;
        ListNode listNode = detectCycle(head);
        System.out.println("res = " + listNode);
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(set.add(cur) != false){
            if(cur == null) return null;
            cur = cur.next;
        }
        return cur;
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
