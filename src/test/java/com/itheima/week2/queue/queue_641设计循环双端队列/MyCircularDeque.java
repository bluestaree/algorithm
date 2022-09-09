package com.itheima.week2.queue.queue_641设计循环双端队列;

public
//
class MyCircularDeque {
    private int[] arr;
    private int h = 0;
    private int t = 0;
    private int cap;
    
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        //MyCircularDeque(k)：构造函数,双端队列的大小为k。
        k++;
        arr = new int[k];
        cap = k;
    }
    
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        // insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
        //是否满了
        if (isFull()) {
            return false;
        }
        //没有满
        h = (h + cap - 1) % cap;
        arr[h] = value;
        return true;
    }
    
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        // insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
        //是否满了
        if (isFull()) {
            return false;
        }
        //没有满
        arr[t] = value;
        t = (t + 1) % cap;
        return true;
    }
    
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        // deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
        if (isEmpty()) {
            return false;
        }
        //有值 
        h = (h + 1) % cap;
        return true;
    }
    
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        // deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
        if (isEmpty()) {
            return false;
        }
        //有值
        t = (t - 1 + cap) % cap;
        return true;
    }
    
    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        // getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
        if (isEmpty()) {
            return -1;
        }
        return arr[h];
    }
    
    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        // getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
        if (isEmpty()) {
            return -1;
        }
        //有值
        return arr[(t - 1 + cap) % cap];
    }
    
    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        // isEmpty()：检查双端队列是否为空。
        return h == t;
    }
    
    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {    // isFull()：检查双端队列是否满了。
        return (t + 1) % cap == h;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
