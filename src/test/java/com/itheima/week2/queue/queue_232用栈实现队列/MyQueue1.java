package com.itheima.week2.queue.queue_232用栈实现队列;

import java.util.Stack;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 16:37
 **/
public

//
class MyQueue1 {
    Stack<Integer> in;
    Stack<Integer> out;
    
    /**
     * Initialize your data structure here.
     */
    //void push(int x) 将元素 x 推到队列的末尾
    public MyQueue1() {
        in = new Stack<>();
        out = new Stack<>();
        
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
    
    // int pop() 从队列的开头移除并返回元素
    public int pop() {
        reverse();
        return out.pop();
    }
    
    private void reverse() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
    
    /**
     * Get the front element.
     */
    // int peek() 返回队列开头的元素
    public int peek() {
        reverse();
        return out.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     */
    // boolean empty() 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

