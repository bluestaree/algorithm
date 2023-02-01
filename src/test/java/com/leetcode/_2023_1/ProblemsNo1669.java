package com.leetcode._2023_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1669. 合并两个链表
 *
 * @author DHW
 * @date 2023/1/30 10:57
 * @Version 1.0
*/
public class ProblemsNo1669 {

    @Test
    public void solution() {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        int a = 1;
        int b = 2;
        System.out.println("res = " + mergeInBetween(list1, a, b, list2));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeA = new ListNode();

        ListNode node = list1;
        for (int i = 0; i <= b; i++) {
            if(i+1 == a) {
                nodeA = node;
            }
            node = node.next;
        }
        nodeA.next = list2;

        ListNode list2LastNode = list2;
        while(true) {
            if(list2LastNode.next == null) {
                break;
            }
            list2LastNode = list2LastNode.next;
        }
        list2LastNode.next = node;
        return list1;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
