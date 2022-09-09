package com.itheima.week2.stack.stack_225用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public
//
class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }
    
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //每次添加的时候都需要反转队列
        queue.add(x);
        //反转
        int size = queue.size();
        for (int i = 1; i < size; i++) {
            queue.add(queue.poll());
        }
    }
    
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }
    
    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }
    
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
