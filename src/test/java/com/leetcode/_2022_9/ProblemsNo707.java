package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 707. 设计链表
 *
 * @author DHW
 * @date 2022/9/23 10:48
 * @Version 1.0
*/
public class ProblemsNo707 {

    @Test
    public void solution() {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3,0);
//        linkedList.deleteAtIndex(2);
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(4);
//        System.out.println("linkedList.get(4) = " + linkedList.get(4));
//        linkedList.addAtHead(4);
//        linkedList.addAtIndex(5,0);
//        linkedList.addAtHead(6);
        //4

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);
//        System.out.println("linkedList.get(4) = " + linkedList.get(1));
//        linkedList.deleteAtIndex(0);
//        System.out.println("linkedList.get(4) = " + linkedList.get(0));
        //2,2

//        linkedList.addAtHead(5);
//        linkedList.addAtIndex(1,2);
//        System.out.println("linkedList.get(1) = " + linkedList.get(1));
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(2);
//        System.out.println("linkedList.get(3) = " + linkedList.get(3));
//        linkedList.addAtTail(1);
//        System.out.println("linkedList.get(5) = " + linkedList.get(5));
//        linkedList.addAtHead(2);
//        System.out.println("linkedList.get(2) = " + linkedList.get(2));
//        linkedList.addAtHead(6);
    }

    class MyLinkedList {

        Node root;

        public MyLinkedList() {
        }

        public int get(int index) {
            if(index < 0 || root == null) { return -1; }
            int len = 0;
            Node node = root;
            while (node != null) {
                if (len == index) {
                    return node.val;
                }
                node = node.next;
                len++;
            }
            return -1;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if(root == null) {
                root = node;
            } else {
                node.next = root;
                root = node;
            }
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if(root == null) {
                root = node;
            } else {
                Node pre = root;
                Node temp = root.next;
                while (temp != null) {
                    pre = temp;
                    temp = temp.next;
                }
                pre.next = node;
            }
        }

        public void addAtIndex(int index, int val) {
            if(index <= 0) {
                addAtHead(val);
                return;
            }

            Node node = new Node(val);
            if(root == null) {
                return;
            } else {
                int len = 1;
                Node prev = root;
                Node next = root.next;
                while (next != null) {
                    if(len == index) {
                        prev.next = node;
                        node.next = next;
                        return;
                    }
                    prev = next;
                    next = next.next;
                    len++;
                }
                if(next == null && len == index) {
                    prev.next = node;
                }
            }
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || root == null) { return; }
            if(index == 0) {
                root = root.next;
            } else {
                int len = 1;
                Node prev = root;
                Node next = root.next;
                while (next != null) {
                    if(len == index) {
                        prev.next = next.next;
                        return;
                    }
                    prev = next;
                    next = next.next;
                    len++;
                }
            }
        }
    }

    class Node {
        int val;
        Node next;
        public Node() {

        }
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
