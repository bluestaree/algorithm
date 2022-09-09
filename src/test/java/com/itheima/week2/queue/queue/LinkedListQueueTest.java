package com.itheima.week2.queue.queue;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 09:31
 **/
public class LinkedListQueueTest {
    @Test
    public void test() {
        Queue queue = new LinkedListQueue();
        queue.add("黑马程序员");
        queue.offer("博学谷");
        queue.offer("传智汇");
        queue.offer("传智专修学院");
        System.out.println("队列是否为空：" + queue.isEmpty() + ",队列元素个数为：" + queue.size());
        System.out.println(queue);
        System.out.println("队列头元素:" + queue.remove());
        System.out.println(queue);
        System.out.println("队列头元素:" + queue.poll());
        System.out.println(queue);
        System.out.println("队列头元素:" + queue.element());
        System.out.println(queue);
        System.out.println("队列头元素:" + queue.peek());
        System.out.println(queue);
    }
}
