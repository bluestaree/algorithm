package com.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * 2. 二两数相加
 *
 *
 * @author DHW
 * @date 2022/9/6 8:45
 * @Version 1.0
*/
public class ProblemsNo2 {

    // 定义结果集
    ListNode result = new ListNode();
    // 进位符
    boolean flag = false;


    @Test
    public void solution() {
//        l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode();
        ListNode l11 = new ListNode();
        ListNode l111 = new ListNode();
        ListNode l1111 = new ListNode();
        ListNode l11111 = new ListNode();
        ListNode l111111 = new ListNode();
        ListNode l1111111 = new ListNode();
        l1.val = 9;
        l1.next = l11;
        l11.val = 9;
        l11.next = l111;
        l111.val = 9;
        l111.next = l1111;
        l1111.val = 9;
        l1111.next = l11111;
        l11111.val = 9;
        l11111.next = l111111;
        l111111.val = 9;
        l111111.next = l1111111;
        l1111111.val = 9;
        ListNode l2 = new ListNode();
        ListNode l22 = new ListNode();
        ListNode l222 = new ListNode();
        ListNode l2222 = new ListNode();
        l2.val = 9;
        l2.next = l22;
        l22.val = 9;
        l22.next = l222;
        l222.val = 9;
        l222.next = l2222;
        l2222.val = 9;
        addTwoNumbers(l1, l2, result);

        while(true) {
            if(result == null) {
                break;
            }
            System.out.println("reuslt = " + result.val);
            result = result.next;
        }
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode node) {
        if(l1 == null && l2 == null && flag == false) {
            return;
        }
        // 计算结果
        int sum = 0;

        ListNode listNode = new ListNode();
        ListNode l1Next = null;
        ListNode l2Next = null;
        if(l1 != null) {
            sum += l1.val;
            l1Next = l1.next;
        }

        if(l2 != null) {
            sum += l2.val;
            l2Next = l2.next;
        }

        if(flag) {
            sum += 1;
            flag = false;
        }

        if((sum / 10) >= 1) {
            flag = true;
            node.val = sum % 10;
        } else {
            node.val = sum;
        }

        if(l1Next != null || l2Next != null || flag) {
            node.next = listNode;
        }
        addTwoNumbers(l1Next ,l2Next, listNode);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
