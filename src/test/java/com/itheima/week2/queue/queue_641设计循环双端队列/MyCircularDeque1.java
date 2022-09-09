package com.itheima.week2.queue.queue_641设计循环双端队列;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 14:20
 **/
public
class MyCircularDeque1 {
    
    int capacity;
    int[] elementData;
    int head;
    int tail;
    
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    
    //MyCircularDeque(k)：构造函数,双端队列的大小为k。
    //
    public MyCircularDeque1(int k) {
        this.capacity = k + 1;
        this.elementData = new int[this.capacity];
        
    }
    
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    // insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
    public boolean insertFront(int value) {
        
        if (isFull()) {
            return false;
        }
        head = (head + capacity - 1) % capacity;
        this.elementData[head] = value;
        return true;
    }
    
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    // insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        this.elementData[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }
    
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    // deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.elementData[head] = 0;
        
        head = (head + 1) % capacity;
        return true;
    }
    
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    // deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        
        //
        tail = (tail - 1 + capacity) % capacity;
        this.elementData[tail] = 0;
        return true;
    }
    
    /**
     * Get the front item from the deque.
     */
    // getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.elementData[head];
        
    }
    
    /**
     * Get the last item from the deque.
     */
    // getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.elementData[(tail - 1 + capacity) % capacity];
    }
    
    /**
     * Checks whether the circular deque is empty or not.
     */
    // isEmpty()：检查双端队列是否为空。
    public boolean isEmpty() {
        return head == tail;
    }
    
    /**
     * Checks whether the circular deque is full or not.
     */
    // isFull()：检查双端队列是否满了。
    public boolean isFull() {
        return head == (tail + 1) % capacity;
    }
    
    @Override
    public String toString() {
        return "MyCircularDeque{" +
                "capacity=" + capacity +
                ", elementData=" + Arrays.toString(elementData) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
