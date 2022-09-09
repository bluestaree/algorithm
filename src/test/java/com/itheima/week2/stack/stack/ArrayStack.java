package com.itheima.week2.stack.stack;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-20 14:29
 **/
public class ArrayStack<E> implements Stack<E> {
    
    Object[] elementData;
    private int elementCount = 0;
    
    public ArrayStack() {
        this.elementData = new Object[10];
    }
    
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("argument error ,capaticy:" + capacity);
        }
        this.elementData = new Object[capacity];
    }
    
    /**
     * 返回栈中元素个数
     *
     * @return
     */
    public int size() {
        return this.elementCount;
    }
    
    /**
     * 判断栈是否为空
     *
     * @return
     */
    
    public boolean empty() {
        return this.elementCount == 0;
    }
    
    /**
     * 将元素压入栈
     *
     * @param item 被存入栈的元素
     * @return
     */
    
    public E push(E item) {
        ensureCapaticy(elementCount + 1);
        
        elementData[elementCount] = item;
        elementCount++;
        return item;
    }
    
    private void ensureCapaticy(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }
    
    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        //借助工具类快速拷贝
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        
    }
    
    /**
     * 获取栈顶元素，但并不移除，如果栈空则返回null
     *
     * @return
     */
    
    public E peek() {
        if (elementCount == 0) {
            return null;
        }
        //判断是否有元素
        return elementAt(elementCount - 1);
    }
    
    private E elementAt(int index) {
        if (index >= elementCount || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + "," +
                    "elementCount=" + this.elementCount);
        }
        return (E) this.elementData[index];
    }
    
    /**
     * 移除栈顶元素并返回，如果栈为空则返回null
     *
     * @return
     */
    
    public E pop() {
        if (elementCount == 0) {
            return null;
        }
        E peek = peek();
        //判断是否有元素
        removeElementAt(elementCount - 1);
        return peek;
    }
    
    private void removeElementAt(int index) {
        if (index >= elementCount || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + "," +
                    "elementCount=" + this.elementCount);
        }
        if (index < this.elementCount - 1) {
            //拷贝数组
            System.arraycopy(this.elementData, index + 1
                    , this.elementData, index, elementCount - index - 1);
        }
        elementCount--;
        elementData[elementCount] = null;
    }
    
    @Override
    public String toString() {
        //将栈中元素按照[1,2,3,4]形式打印
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.elementCount; i++) {
            sb.append(this.elementData[i]);
            if (i != this.elementCount - 1) {
                sb.append(" ,");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
