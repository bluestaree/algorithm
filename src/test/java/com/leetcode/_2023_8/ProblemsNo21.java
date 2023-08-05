package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 21. 合并两个有序链表
 *
 * @author DHW
 * @date 2023/8/5 10:24
 * @Version 1.0
*/
public class ProblemsNo21 {

    @Test
    public void solution() {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        node1.next = node11;
        node11.next = node12;
        ListNode node2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        node2.next = node21;
        node21.next = node22;
        ListNode listNode = mergeTwoLists(node1, node2);
        System.out.println("res = " + listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode();
        ListNode res = cur;
        while(true) {
            if(list1 == null) {
                cur.next = list2;
                break;
            }
            if(list2 == null) {
                cur.next = list1;
                break;
            }
            if(list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        return res.next;
    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
