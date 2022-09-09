package com.itheima.week10.lru;

import java.util.HashMap;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-17 17:28
 **/
class LRUCache {
    private int capaticity;
    private int size = 0;
    private Node head = new Node();
    private Node tail = new Node();
    private HashMap<Integer, Node> hashTable = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capaticity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = hashTable.get(key);
        if (node == null) {
            
            return -1;
        }
        //删除节点,
        removeNode(node);
        //添加节点到first
        addToFirst(node);
        return node.v;
    }
    
    /*
    * 如果关键字已经存在，则变更其数据值；
如果关键字不存在，则插入该组「关键字-值」。
当缓存容量达到上限时，
它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    * */
    public void put(int key, int value) {
        Node node = hashTable.get(key);
        //如果关键字已经存在，则变更其数据值
        if (node != null) {
            node.v = value;
            removeNode(node);
            addToFirst(node);
            return;
        }
        // 如果关键字不存在，则插入该组「关键字-值」。
        Node first = new Node(value, key);
        hashTable.put(key, first);
        addToFirst(first);
        this.size++;
        // 当缓存容量达到上限时，
        // 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
        if (this.size > this.capaticity) {
            Node last = tail.prev;
            removeNode(last);
            hashTable.remove(last.key);
            this.size--;
        }
    }
    
    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        node.next = null;
        node.prev = null;
        next.prev = prev;
        prev.next = next;
    }
    
    private void addToFirst(Node first) {
        Node second = head.next;
        head.next = first;
        second.prev = first;
        first.prev = head;
        first.next = second;
    }
    
    static class Node {
        private int v;
        private int key;
        private Node prev;
        private Node next;
        
        public Node() {
        }
        
        public Node(int v, int key) {
            this.v = v;
            this.key = key;
        }
    }
}
