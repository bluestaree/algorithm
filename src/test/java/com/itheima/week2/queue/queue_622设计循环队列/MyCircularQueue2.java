package com.itheima.week2.queue.queue_622设计循环队列;

public
//
class MyCircularQueue2 {
    private int[] arr;
    private int size = 0;
    private int capacity;
    //头
    private int front = 0;
    //尾
    private int rear = 1;
    
    public MyCircularQueue2(int capacity) {
        //         MyCircularQueue(k): 构造器，设置队列长度为 k 。
        this.arr = new int[capacity + 1];
        this.capacity = capacity + 1;
    }
    
    public boolean enQueue(int value) {
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
        if (isEmpty()) {
            front = 0;
            rear = 1;
            arr[front] = value;
            size++;
            return true;
        }
        //不为空,需要注意取余
        int i = (rear + 1) % capacity;
        if (i == front) {
            //满了,不能添加
            return false;
        }
        //不满
        arr[rear] = value;
        rear = i;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        // deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
        if (isEmpty()) {
            return false;
        }
        //拿走一个
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        // Front: 从队首获取元素。如果队列为空，返回 -1 。
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        // Rear: 获取队尾元素。如果队列为空，返回 -1 。
        if (isEmpty()) {
            return -1;
        }
        return arr[rear >= 1 ? rear - 1 : capacity - 1];
    }
    
    public boolean isEmpty() {
        // isEmpty(): 检查循环队列是否为空。
        return (size == 0);
    }
    
    public boolean isFull() {
        // isFull(): 检查循环队列是否已满。 
        return size == (capacity - 1);
    }
}
