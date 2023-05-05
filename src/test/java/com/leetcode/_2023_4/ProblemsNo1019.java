package com.leetcode._2023_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1019. 链表中的下一个更大节点
 *
 * @author DHW
 * @date 2023/4/10 16:13
 * @Version 1.0
*/
public class ProblemsNo1019 {

    @Test
    public void solution() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println("res = " + nextLargerNodes(listNode1));
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            list.add(val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if(val < list.get(j)) {
                    res[i] = list.get(j);
                    break;
                }
            }
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
