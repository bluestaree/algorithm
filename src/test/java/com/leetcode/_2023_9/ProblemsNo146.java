package com.leetcode._2023_9;

import org.junit.Test;

import java.util.*;


/**
 * 146. LRU 缓存
 *
 * @author DHW
 * @date 2023/9/24 14:54
 * @Version 1.0
*/
public class ProblemsNo146 {

    @Test
    public void solution() {
    }

    class LRUCache {

        class Node {
            Node pre;
            Node next;
            int key;
            int val;

            Node() {
            }

            Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, Node> cache;
        private int capacity;
        private int size = 0;
        private Node head = new Node();
        private Node tail = new Node();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                Node node = new Node(key, value);
                cache.put(key, node);
                addHead(node);
                size++;
                if(size > capacity) {
                    cache.remove(removeTail().key);
                    size--;
                }
            }
        }

        private Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addHead(node);
        }

        private void addHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next = node;
            node.next.pre = node;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

    }

}
