package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 232. 用栈实现队列
 *
 * @author DHW
 * @date 2024/3/4 9:19
 * @Version 1.0
*/
public class ProblemsNo232 {

    @Test
    public void solution() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    class MyQueue {
        private Deque<Integer> q1 = new ArrayDeque();
        private Deque<Integer> q2 = new ArrayDeque();

        public MyQueue() {

        }

        public void push(int x) {
            q2.push(x);
        }

        public int pop() {
            peek();
            return q1.pop();
        }

        public int peek() {
            if(!q1.isEmpty()) {
                return q1.peek();
            }
            if(q2.isEmpty()) {
                return -1;
            }
            while(!q2.isEmpty()) {
                q1.push(q2.pop());
            }
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

}

