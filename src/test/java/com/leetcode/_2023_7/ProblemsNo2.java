package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2. 两数相加
 *
 * @author DHW
 * @date 2023/7/2 11:42
 * @Version 1.0
*/
public class ProblemsNo2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode pre = new ListNode();
        ListNode result = pre;
        while(true) {
            boolean a = l1 == null;
            boolean b = l2 == null;
            if(a && b) {
                break;
            }
            int i1 = a ? 0 : l1.val;
            int i2 = b ? 0 : l2.val;
            int res = flag ? i1 + i2 + 1 : i1 + i2;
            if(res >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            pre.next = new ListNode(res % 10);
            pre = pre.next;
            l1 = a ? null : l1.next;
            l2 = b ? null : l2.next;
        }

        if(flag) {
            pre.next = new ListNode(1);
        }
        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        boolean flag = false;
        int firstNum = l1.val + l2.val;
        if(firstNum >= 10) {
            flag = true;
        }
        ListNode result = new ListNode(firstNum % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode pre = result;
        while(true) {
            boolean a = l1 == null;
            boolean b = l2 == null;
            if(a && b) {
                break;
            }
            int i1 = a ? 0 : l1.val;
            int i2 = b ? 0 : l2.val;
            int res = flag ? i1 + i2 + 1 : i1 + i2;
            if(res >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            pre.next = new ListNode(res % 10);
            pre = pre.next;
            l1 = a ? null : l1.next;
            l2 = b ? null : l2.next;
        }

        if(flag) {
            pre.next = new ListNode(1);
        }
        return result;
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
