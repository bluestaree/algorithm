package com.leetcode._2024_1;

import org.junit.Test;


/**
 * 83. 删除排序链表中的重复元素
 *
 * @author DHW
 * @date 2024/1/14 10:29
 * @Version 1.0
*/
public class ProblemsNo83 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        System.out.println("res = " + deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
          return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(true){
            while(cur != null && cur.val == pre.val) {
                cur = cur.next;
                pre.next = cur;
            }
            if(cur == null) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
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

