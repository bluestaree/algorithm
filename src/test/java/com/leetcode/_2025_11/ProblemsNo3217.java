package com.leetcode._2025_11;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3217. 从链表中移除在数组中存在的节点
 *
 * @author DHW
 * @date 2025/11/1 10:33
 * @Version 1.0
*/
public class ProblemsNo3217 {

    @Test
    public void solution() {
        int[] nums = new int[]{1};
        ListNode head = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(2);
        head.next = node11;
        node11.next = node12;
        ListNode listNode = modifiedList(nums, head);
        System.out.println("res = " + listNode);
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        ListNode dummy = new ListNode(0, head);
        for (ListNode pre = dummy; pre.next != null;) {
            if (s.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
