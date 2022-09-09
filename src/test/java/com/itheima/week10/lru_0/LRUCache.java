package com.itheima.week10.lru_0;

import java.util.HashMap;

/**
 * @program: algo_pro
 * @description: 这个是缓存LRU
 * @author: zhanghz001
 * @create: 2021-10-12 11:15
 **/
public class LRUCache {
    private int capacity;
    
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int size = 0;
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //需要删除node,
        removeNode(node);
        //需要插入到头部
        addToFirst(node);
        
        //返回结果
        return node.val;
    }
    
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }
    
    private void addToFirst(Node node) {
        Node h1 = head.next;
        head.next = node;
        node.next = h1;
        h1.prev = node;
        node.prev = head;
    }
    
    /**
     * 如果关键字已经存在，则变更其数据值；
     * 如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，
     * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    public void put(int key, int value) {
        //查看是否有
        Node node = map.get(key);
        if (node == null) {
            //没有值,
            //map中添加
            node = new Node(value, key);
            map.put(key, node);
            
            //链表头添加 
            addToFirst(node);
            
            //容量达到,需要删除
            if (size == capacity) {
                //删除尾部的元素
                removeLast();
            } else {
                size++;
            }
            
        } else {
            //有node,
            removeNode(node);
            node.val = value;
            addToFirst(node);
        }
    }
    
    private void removeLast() {
        Node t0 = tail.prev;
        Node t1 = t0.prev;
        t1.next = tail;
        tail.prev = t1;
        t0.next = null;
        t0.prev = null;
        map.remove(t0.key);
    }
    
    //
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    //
    static class Node {
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node() {
            
        }
        
        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
        
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    
}
