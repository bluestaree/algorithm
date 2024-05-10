package com.leetcode._2024_4;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * 706. 设计哈希映射
 *
 * @author DHW
 * @date 2024/4/1 9:50
 * @Version 1.0
*/
public class ProblemsNo706 {

    @Test
    public void solution() {
        MyHashMap obj = new MyHashMap();
        obj.put(1,2);
        int param_2 = obj.get(1);
        obj.remove(1);
    }

    class MyHashMap {

        class Node{
            private int key;
            private int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }


        int len = 1000;
        LinkedList<Node>[] data;

        public MyHashMap() {
            data = new LinkedList[len];
            for (int i = 0; i < len; i++) {
                data[i] = new LinkedList<Node>();
            }
        }

        public void put(int key, int value) {
            int i = hash(key);
            Iterator iterator = data[i].iterator();
            while(iterator.hasNext()) {
                Node node = (Node) iterator.next();
                if(node.key == key) {
                    node.setValue(value);
                    return;
                }
            }
            Node node = new Node(key, value);
            data[i].add(node);
        }

        public int get(int key) {
            int i = hash(key);
            Iterator iterator = data[i].iterator();
            while(iterator.hasNext()) {
                Node node = (Node) iterator.next();
                if(node.key == key) {
                    return node.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int i = hash(key);
            Iterator iterator = data[i].iterator();
            while(iterator.hasNext()) {
                Node node = (Node) iterator.next();
                if(node.key == key) {
                    iterator.remove();
                    break;
                }
            }
        }

        private int hash(int key) {
            return key % len;
        }
    }
}

