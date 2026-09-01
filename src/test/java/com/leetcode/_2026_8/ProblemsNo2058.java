package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 2058. 找出临界点之间的最小和最大距离
 *
 * @author DHW
 * @date 2026/8/31 8:16
 * @Version 1.0
*/
public class ProblemsNo2058 {

    @Test
    public void solution() {
        ListNode head = new ListNode(18);
        ListNode node1 = new ListNode(6);
        head.next = node1;
        ListNode node2 = new ListNode(10);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        System.out.println("res = " + nodesBetweenCriticalPoints(head));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ListNode pre = head;
        ListNode cur = pre.next;
        int deep = 1;
        int first = 0;
        int preV = 0;
        while (cur != null && cur.next != null) {
            if(pre.val > cur.val && cur.val < cur.next.val || pre.val < cur.val && cur.val > cur.next.val) {
                if(first == 0) {
                    first = deep;
                } else {
                    ans[1] = deep - first;
                }
                if(preV != 0) {
                    ans[0] = Math.min(ans[0], deep - preV);
                }
                preV = deep;
            }
            pre = cur;
            cur = cur.next;
            deep++;
        }
        if(ans[0] == Integer.MAX_VALUE) {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
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

