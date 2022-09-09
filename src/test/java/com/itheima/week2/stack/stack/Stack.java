package com.itheima.week2.stack.stack;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-20 14:27
 **/
public interface Stack<E> {
    
    /**
     * 返回栈中元素个数
     *
     * @return
     */
    public int size();
    
    /**
     * 判断栈是否为空
     *
     * @return
     */
    
    public boolean empty();
    
    /**
     * 将元素压入栈
     *
     * @param item 被存入栈的元素
     * @return
     */
    
    public E push(E item);
    
    /**
     * 获取栈顶元素，但并不移除，如果栈空则返回null
     *
     * @return
     */
    
    public E peek();
    
    /**
     * 移除栈顶元素并返回，如果栈为空则返回null
     *
     * @return
     */
    
    public E pop();
}
