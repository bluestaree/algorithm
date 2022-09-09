package com.itheima.week3.hash;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-22 16:39
 **/
public class HashTest {
    
    public boolean isAnagram1(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null) {
            return false;
        } else if (t == null) {
            return false;
        }
        //s,t都不是负数
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> smap = toMap(s);
        HashMap<Character, Integer> tmap = toMap(t);
        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            Character key = entry.getKey();
            Integer tint = tmap.get(key);
            Integer sint = entry.getValue();
            if (!sint.equals(tint)) {
                return false;
            }
        }
        return true;
    }
    
    private HashMap<Character, Integer> toMap(String str) {
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    @Test
    public void test234_2() {
        //1->2->2->1
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome1(node1));
    }
    
    public boolean isPalindrome1(ListNode head) {
        //初始值处理
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        ListNode two = head;
        while (two != null) {
            if (stack.pop() == two.val) {
                two = two.next;
            } else {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void test234_1() {
        //1->2->2->1
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(node1));
    }
    
    public boolean isPalindrome(ListNode head) {
        //初始值处理
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        //查找中间点
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        ListNode curr = null;
        while (f != null && f.next != null) {
            
            f = f.next.next;
            curr = s;
            s = s.next;
            curr.next = prev;
            prev = curr;
            
        }
        //奇数
        if (f != null) {
            s = s.next;
        }
        //
        
        while (s != null && curr != null) {
            if (s.val == curr.val) {
                s = s.next;
                curr = curr.next;
            } else {
                return false;
            }
        }
        return true;
    }
    
}
