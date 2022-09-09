package com.itheima.week2.stack.stack_test155最小栈;

import java.util.LinkedList;

/**
 * 155. 最小栈
 */
class MinStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();
    
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        
        //看看这个val的大小是不是最小
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
