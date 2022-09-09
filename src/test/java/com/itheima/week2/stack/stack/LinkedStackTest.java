package com.itheima.week2.stack.stack;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-20 15:06
 **/
public class LinkedStackTest {
    @Test
    public void test() {
        Stack stack = new LinkedStack();
        //元素入栈
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println("栈中元素个数:" + stack.size() + ",栈是否为空:" + stack.empty());
        System.out.println("打印输出栈:" + stack);
        System.out.println("栈顶元素为：" + stack.peek());
        System.out.println("元素出栈" + stack.pop());
        System.out.println("打印输出栈" + stack);
        
    }
}
