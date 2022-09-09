package com.itheima.week2.stack.stack_225用队列实现栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 16:59
 **/
public
//
class MyStack1 {
    Deque<Integer> q;
    
    /**
     * Initialize your data structure here.
     */
    public MyStack1() {
        q = new LinkedList<>();
    }
    
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.offer(x);
        //少一次循环
        for (int i = 1; i < q.size(); i++) {
            q.add(q.poll());
        }
    }
    
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.remove();
    }
    
    /**
     * Get the top element.
     */
    public int top() {
        return q.element();
    }
    
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}
