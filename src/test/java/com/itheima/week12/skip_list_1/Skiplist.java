package com.itheima.week12.skip_list_1;

import java.util.Random;

/**
 * @program: algo_pro
 * @description: 跳表
 * @author: zhanghz001
 * @create: 2021-10-18 15:07
 **/
public
//跳表实现
class Skiplist {
    private int MAX_LEVEL = 32;
    private float p = 0.25f;
    private Random random = new Random();
    Node head;//头节点
    int levelCount; //最高层数
    
    public Skiplist() {
        this.head = new Node(-1, MAX_LEVEL);
    }
    
    public boolean search(int target) {
        Node p = head;
        //从最高层开始查找
        for (int i = levelCount - 1; i >= 0; i--) {
            
            while (p.next[i] != null && p.next[i].key < target) {
                p = p.next[i];
            }
        }
        //target 都在第一层,判断是否找到
        if (p.next[0] != null && p.next[0].key == target) {
            return true;
        }
        return false;
    }
    
    public void add(int num) {
        //定义新元素添加到第几层
        int level = head.next[0] == null ? 1 : randomLevel();
        //如果随机level超过目前最大层数,意味着要上涨很多层,选择每次上涨一层
        if (level > levelCount) {
            level = ++levelCount;
        }
        //创建新节点
        Node newNode = new Node(num, level);
        //从最高层开始查找,找到新节点要插入的位置
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < num) {
                p = p.next[i];
            }
            //证明从这层往下,到最底层;
            //某些节点后需要添加新节点newNode
            if (i < level) {
                if (p.next[i] == null) {
                    //直接在后面接上新节点
                    p.next[i] = newNode;
                } else {
                    //在当前节点和当前节点后面节点中间插入新节点
                    Node next = p.next[i];
                    p.next[i] = newNode;
                    newNode.next[i] = next;
                }
                
            }
        }
    }
    // bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 
    // 如果存在多个 num ，删除其中任意一个即可。
    
    public boolean erase(int key) {
        boolean flag = false;
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
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
    
    //函数随机产生一个level
    public int randomLevel() {
        int level = 1;
        while (random.nextFloat() < p && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    
    class Node {
        //关键字
        int key;
        /**
         * 表示当前节点在当前层的下一个节点
         */
        Node[] next;
        
        public Node(int key, int level) {
            this.key = key;
            this.next = new Node[level];
        }
    }
}
