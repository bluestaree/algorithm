package com.leetcode._2023_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 460. LFU 缓存
 *
 * @author DHW
 * @date 2023/9/25 11:41
 * @Version 1.0
*/
public class ProblemsNo460 {

    @Test
    public void solution() {
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
    }

    class LFUCache {

        class Node {
            int key;
            int val;
            int useTime;
            Node prev;
            Node next;

            Node(){}

            Node(int key, int val, int useTime) {
                this.key = key;
                this.val = val;
                this.useTime = useTime;
            }
        }

        class NodeUseTimeLinkedList {
            private Node head;
            private Node tail;

            NodeUseTimeLinkedList(){
                this.head = new Node();
                this.tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            public int remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return node.key;
            }

            public int removeLast() {
                return remove(tail.prev);
            }

            public void addHead(Node node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            public boolean isEmpty() {
                return head.next == tail;
            }
        }

        private Map<Integer, Node> cache = new HashMap();
        private Map<Integer, NodeUseTimeLinkedList> useTimeMap = new HashMap();
        private int capacity;
        private int size = 0;
        private int minUseTime = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if(!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            incrUseTime(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                incrUseTime(node);
            } else {
                size++;
                if(size > capacity) {
                    NodeUseTimeLinkedList list = useTimeMap.get(minUseTime);
                    cache.remove(list.removeLast());
                }
                Node node = new Node(key, value, 1);
                minUseTime = 1;
                NodeUseTimeLinkedList cur = useTimeMap.getOrDefault(node.useTime, new NodeUseTimeLinkedList());
                cur.addHead(node);
                cache.put(key, node);
                useTimeMap.put(node.useTime, cur);
            }
        }

        private void incrUseTime(Node node) {
            NodeUseTimeLinkedList old = useTimeMap.get(node.useTime);
            old.remove(node);
            if(old.isEmpty() && minUseTime == node.useTime) {
                minUseTime++;
            }
            node.useTime++;
            NodeUseTimeLinkedList cur = useTimeMap.getOrDefault(node.useTime, new NodeUseTimeLinkedList());
            cur.addHead(node);
            useTimeMap.put(node.useTime, cur);
        }
    }
}
