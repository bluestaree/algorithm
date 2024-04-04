package com.leetcode._2024_3;

import org.junit.Test;

import java.util.*;


/**
 * 225. 用队列实现栈
 *
 * @author DHW
 * @date 2024/3/3 10:58
 * @Version 1.0
*/
public class ProblemsNo225 {

    @Test
    public void solution() {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.top();
        System.out.println("res = " + param_2);
        int param_3 = obj.pop();
        System.out.println("res = " + param_3);
        boolean param_4 = obj.empty();
        System.out.println("res = " + param_4);
        Queue<Integer> q3  = new LinkedList<Integer>();
        q3.offer(1);
        q3.offer(2);
        q3.offer(3);
        q3.poll();
        q3.poll();
        q3.poll();
    }


    class MyStack {
        private Deque<Integer> q1 = new ArrayDeque();
        private Deque<Integer> q2 = new ArrayDeque();

        public MyStack() {

        }

        public void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Deque q = q2;
            q2 = q1;
            q1 = q;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

}

