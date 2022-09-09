package com.itheima.week2.stack.stack;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-20 14:29
 **/
public class LinkedStack<E> implements Stack<E> {
    private int size = 0;
    //
    Node<E> head = null;
    
    /**
     * 返回栈中元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }
    
    /**
     * 判断栈是否为空
     *
     * @return
     */
    
    public boolean empty() {
        return size == 0;
    }
    
    /**
     * 将元素压入栈
     *
     * @param item 被存入栈的元素
     * @return
     */
    
    public E push(E item) {
        Node<E> node = new Node<E>(item, head);
        head = node;
        size++;
        return item;
    }
    
    /**
     * 获取栈顶元素，但并不移除，如果栈空则返回null
     *
     * @return
     */
    
    public E peek() {
        if (head == null) {
            return null;
        } else {
            return head.val;
        }
    }
    
    /**
     * 移除栈顶元素并返回，如果栈为空则返回null
     *
     * @return
     */
    
    public E pop() {
        if (head == null) {
            return null;
        } else {
            Node<E> item = head;
            head = head.next;
            item.next = null;
            size--;
            return item.val;
        }
    }
    
    private static class Node<E> {
        E val;
        Node<E> next;
        
        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public LinkedStack() {
    }
    
    @
            Override
    public String toString() {
        //打印1->2->3->null格式的数据
        StringBuilder sb = new StringBuilder();
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        return sb.append("null").toString();
    }
}
