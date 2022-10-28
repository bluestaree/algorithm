package com.leetcode._2022_10;

import org.junit.Test;

import java.util.*;


/**
 * 817. 链表组件
 *
 * @author DHW
 * @date 2022/10/12 9:23
 * @Version 1.0
*/
public class ProblemsNo817 {

    @Test
    public void solution() {

        ListNode h4 = new ListNode(4);
        ListNode h3 = new ListNode(3, h4);
        ListNode h2 = new ListNode(2, h3);
        ListNode h1 = new ListNode(1, h2);
        ListNode head = new ListNode(0, h1);
        int[] nums = new int[]{0,3,1,4};

        System.out.println("nums = " + numComponents(head, nums));
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int numComponents(ListNode head, int[] nums) {
        int[] markNums = new int[10000];
        for (int num : nums) {
            markNums[num] = 1;
        }
        int count = 0;
        int result = 0;
        ListNode node = head;
        int val;
        boolean mark = false;
        // 遍历链表
        while(node != null){
            if(count == nums.length) {
                return result;
            }
            val = node.val;
            if(markNums[val] == 1) {
                count++;
                if(!mark) {
                    result++;
                    mark = true;
                }
            }else {
                mark = false;
            }
            node = node.next;
        }
        return result;
    }

    public int numComponents1(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        ListNode node = head;
        int val;
        boolean mark = false;
        // 遍历链表
        while(node != null){
            if(set.isEmpty()) {
                return result;
            }
            val = node.val;
            if(set.contains(val)) {
                set.remove(val);
                if(!mark) {
                    result++;
                    mark = true;
                }
            }else {
                mark = false;
            }
            node = node.next;
        }
        return result;
    }
}
