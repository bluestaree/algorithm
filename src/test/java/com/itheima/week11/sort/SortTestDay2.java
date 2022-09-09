package com.itheima.week11.sort;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-21 21:06
 **/
public class SortTestDay2 {
    
    public String frequencySort1(String s) {
        //map记录出现次数
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        StringBuilder sb = new StringBuilder();
        entries.stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(o -> {
            char c = o.getKey();
            int value = o.getValue();
            for (int i = 0; i < value; i++) {
                sb.append(c);
            }
        });
        return sb.toString();
    }
    
    @Test
    public void test451根据字符出现频率排序() {
        System.out.println(frequencySort("tree"));
    }
    
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        //每个字母出现的频率
        int[] frequent = new int[128];
        for (char c : chars) {
            frequent[c]++;
        }
        
        //排序,通过大顶堆
        PriorityQueue<B> queue = new PriorityQueue<B>(((o1, o2) -> o2.fre - o1.fre));
        
        //加入大顶堆
        for (int i = 0; i < frequent.length; i++) {
            queue.offer(new B(frequent[i], (char) i));
        }
        
        //加入到string中
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            B poll = queue.poll();
            for (int i = 0; i < poll.fre; i++) {
                sb.append(poll.c);
            }
        }
        return sb.toString();
    }
    
    static class B {
        int fre;
        char c;
        
        public B(int fre, char c) {
            this.fre = fre;
            this.c = c;
        }
    }
    
    @Test
    public void test147对链表进行插入排序() {
        
        ListNode l4 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        
        l4.next = l2;
        l2.next = l1;
        l1.next = l3;
        System.out.println(insertionSortList(l4));
    }
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode();
        first.next = head;
        //
        ListNode node = head;
        ListNode next;
        while (node.next != null) {
            next = node.next;
            if (node.val <= next.val) {
                //不需要调整
                node = next;
            } else {
                //需要将元素进行插入排序
                node.next = next.next;
                next.next = null;
                ListNode pre = first;
                ListNode curr = pre.next;
                ListNode insert = next;
                while (true) {
                    if (curr.val <= insert.val) {
                        pre = curr;
                        curr = curr.next;
                    } else {
                        pre.next = insert;
                        insert.next = curr;
                        break;
                    }
                }
            }
        }
        
        return first.next;
    }
    
    class ListNode {
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
        
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}


