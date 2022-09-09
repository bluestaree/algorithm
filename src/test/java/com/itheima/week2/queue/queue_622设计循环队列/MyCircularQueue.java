package com.itheima.week2.queue.queue_622设计循环队列;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 11:44
 **/
public
//
class MyCircularQueue {
    int capacity;
    
    int[] elementData;
    
    int front;
    
    int rear;
    
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k + 1;
        elementData = new int[this.capacity];
        front = rear = 0;
    }
    
    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        
        if (isFull()) {
            return false;
        }
        this.elementData[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }
    
    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elementData[front];
        
    }
    
    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //rear初始值为0,所以要注意+capacity
        return elementData[(rear + capacity - 1) % capacity];
    }
    
    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }
    
    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

//
class MyCircularQueue1 {
    
    private int max;
    private int size = 0;
    private Node head;
    private Node tail;
    
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    
    //MyCircularQueue(k): 构造器，设置队列长度为 k 。
    public MyCircularQueue1(int k) {
        this.max = k;
        
    }
    
    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (size == max) {
            return false;
        } else if (size == 0) {
            head = new Node(value, null, null);
            tail = head;
            tail.next = head;
            tail.prev = head;
            size++;
            return true;
        } else {
            Node tmp = tail;
            tail = new Node(value, head, tmp);
            tmp.next = tail;
            tail.next = head;
            head.prev = tail;
            size++;
            return true;
        }
    }
    
    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (size == 0) {
            return false;
        } else {
            Node tmp = head;
            head = head.next;
            tail.next = head;
            head.prev = tail;
            tmp.next = null;
            tmp.prev = null;
            size--;
            return true;
        }
    }
    
    /**
     * Get the front item from the queue.
     */
// Front: 从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if (size == 0) {
            return -1;
        } else {
            return head.val;
        }
    }
    
    /**
     * Get the last item from the queue.
     */
// Rear: 获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (size == 0) {
            return -1;
        } else {
            return tail.val;
        }
    }
    
    /**
     * Checks whether the circular queue is empty or not.
     */
// isEmpty(): 检查循环队列是否为空。
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Checks whether the circular queue is full or not.
     */
// isFull(): 检查循环队列是否已满。
    public boolean isFull() {
        return size >= max;
    }
    
    static class Node {
        int val;
        Node next;
        Node prev;
        
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
