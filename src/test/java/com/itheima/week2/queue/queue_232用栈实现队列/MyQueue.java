package com.itheima.week2.queue.queue_232用栈实现队列;

import java.util.Stack;

public
//
class MyQueue {
    
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        
    }
    
    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }
    
    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        reverse();
        return out.pop();
    }
    
    private void reverse() {
        //如果out有就直接输出
        if (out.isEmpty()) {
            //需要从in中获取
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
    
    /**
     * Get the front element.
     */
    public int peek() {
        reverse();
        return out.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
