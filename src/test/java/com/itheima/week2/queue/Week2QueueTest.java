package com.itheima.week2.queue;

import com.itheima.week2.queue.queue_622设计循环队列.MyCircularQueue;
import com.itheima.week2.queue.queue_622设计循环队列.MyCircularQueue2;
import com.itheima.week2.queue.queue_641设计循环双端队列.MyCircularDeque;
import com.itheima.week2.queue.queue_641设计循环双端队列.MyCircularDeque1;
import com.itheima.week2.queue.queue_703数据流中的第K大元素.KthLargest1;
import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 12:09
 **/
public class Week2QueueTest {
    @Test
    public void test622设计循环队列4() {
        MyCircularQueue2 circularQueue = new MyCircularQueue2(6); // 设置长度为 3
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        
    }
    
    @Test
    public void test622设计循环队列3() {
        MyCircularQueue2 circularQueue = new MyCircularQueue2(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        // 返回 3
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        
    }
    
    @Test
    public void test622设计循环队列2() {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        // 返回 3
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        
    }
    
    @Test
    public void test622设计循环队列() {
        MyCircularQueue circularQueue = new MyCircularQueue(8); // 设置长度为 3
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(9));
        System.out.println(circularQueue.enQueue(5));
        System.out.println(circularQueue.enQueue(0));
        
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isEmpty());
        
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        
        // 返回 3
        System.out.println(circularQueue.deQueue());
        
    }
    
    @Test
    //[4, 5, 8, 2]
    public void test703数据流中的第K大元素() {
        KthLargest1 kthLargest = new KthLargest1(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
        
    }
    
    @Test
    public void test641设计循环双端队列1() {
        // 设置容量大小为3
        MyCircularDeque1 circularDeque = new MyCircularDeque1(3);
        System.out.println(circularDeque.insertLast(1));
        
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        
        System.out.println(circularDeque);
        
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        
        System.out.println(circularDeque);
        System.out.println(circularDeque.getFront());
        
    }
    
    @Test
    public void test641设计循环双端队列() {
        // 设置容量大小为3
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));
        
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        
        System.out.println(circularDeque);
        
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        
        System.out.println(circularDeque);
        System.out.println(circularDeque.getFront());
        
    }
}
