package com.itheima.week2.queue.queue;

import java.util.NoSuchElementException;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 09:25
 **/
public class LinkedListQueue<E> implements Queue<E> {
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;
    
    @Override
    public boolean add(E e) {
        //异常,加数据
        linkLast(e);
        
        return true;
    }
    
    private void linkLast(E e) {
        Node<E> t = tail;
        tail = new Node<E>(e, null);
        if (size == 0) {
            head = tail;
        } else {
            t.next = tail;
        }
        size++;
    }
    
    @Override
    public boolean offer(E e) {
        //没有异常,加数据
        linkLast(e);
        return true;
    }
    
    @Override
    public E remove() {
        //异常,取数据
        if (size == 0) {
            //抛出异常
            throw new NoSuchElementException("队列为空!");
        }
        
        Node<E> out = unlinkHead();
        return out.val;
        
    }
    
    private Node<E> unlinkHead() {
        Node<E> out = head;
        head = head.next;
        out.next = null;
        if (size == 1) {
            tail = null;
        }
        size--;
        return out;
    }
    
    @Override
    public E poll() {
        //没有异常,取数据
        if (size == 0) {
            //抛出异常
            return null;
        }
        
        Node<E> out = unlinkHead();
        return out.val;
    }
    
    @Override
    public E element() {
        //异常,获取数据
        if (size == 0) {
            throw new NoSuchElementException("队列为空!");
        }
        return head.val;
    }
    
    @Override
    public E peek() {
        //没有异常,获取数据
        if (size == 0) {
            return null;
        }
        return head.val;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    static class Node<E> {
        Node<E> next;
        E val;
        
        public Node() {
        }
        
        public Node(E val, Node<E> next) {
            this.next = next;
            this.val = val;
        }
    }
    
    @Override
    public String toString() {
        //不是多线程的时候用stringbuilder好一些,性能好
        StringBuilder sb = new StringBuilder();
        // stringbuffer是线程安全的,实现原理是通过synchronize锁实现
        //synchronized synchronized
        new StringBuffer();
        Node<E> tmp = head;
        while (tmp != null) {
            sb.append(tmp.val).append("->");
            tmp = tmp.next;
        }
        sb.append("NULL");
        return sb.toString();
        
    }
}
