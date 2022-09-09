package com.itheima.week12.skip_list;

import java.util.Random;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-02-01 14:07
 **/
public
//  
class Skiplist {
    private int MAX_LEVEL = 32;
    private Node sen = new Node(0, new Node[MAX_LEVEL]);
    private float p = 0.25f;
    Random random = new Random();
    private int max = 0;
    
    public Skiplist() {
        
    }
    //bool search(int target) : 返回target是否存在于跳表中。
    
    public boolean search(int key) {
        Node p = sen;
        for (int i = max - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < key) {
                p = p.next[i];
            }
            
        }
        //p为目标 的前一个节点
        return p.next[0] != null && p.next[0].key == key;
        
    }
    
    public int randomlevel() {
        int level = 1;
        while (random.nextFloat() < p && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    // void add(int num): 插入一个元素到跳表。
    
    public void add(int key) {
        //创建当前节点
        int level = randomlevel();
        //和max比较一下
        if (level > max) {
            level = ++max;
        }
        Node[] next = new Node[level];
        Node node = new Node(key, next);
        
        //找到对应的位置,然后插入其中,设置next指针
        Node p = sen;
        for (int i = max - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < key) {
                p = p.next[i];
            }
            if (i < level) {
                Node nexti = p.next[i];
                p.next[i] = node;
                node.next[i] = nexti;
            }
        }
    }
    // bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 
    // 如果存在多个 num ，删除其中任意一个即可。
    
    public boolean erase(int key) {
        boolean flag = false;
        Node p = sen;
        for (int i = max - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < key) {
                p = p.next[i];
            }
            if (p.next[i] != null && p.next[i].key == key) {
                flag = true;
                p.next[i] = p.next[i].next[i];
            }
        }
        //p为目标 的前一个节点
        return flag;
    }
    
    static class Node {
        Node[] next;
        int key;
        
        public Node(int key, Node[] next) {
            this.next = next;
            this.key = key;
        }
    }
}
