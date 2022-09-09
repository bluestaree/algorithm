package com.itheima.week2.queue.queue;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-21 09:21
 **/
public interface Queue<E> {
    /**
     * 在不违反容量限制的情况下立即将指定的元素插入此队列，成功时返回true，
     * 如果当前没有可用空间，则抛出IllegalStateException异常
     *
     * @param e
     * @return
     */
    boolean add(E e);
    
    /**
     * 在不违反容量限制的情况下立即将指定的元素插入到此队列中。成功时返回true，
     *
     * @param e
     * @return
     */
    boolean offer(E e);
    
    /**
     * 检索并删除此队列的头。如果队列为空抛出NoSuchElementException
     *
     * @return
     */
    E remove();
    
    /**
     * 检索并删除此队列的头，如果此队列为空，则返回null。
     *
     * @return
     */
    E poll();
    
    /**
     * 检索但不删除此队列的头。如果队列为空抛出NoSuchElementException
     * 此方法与peek的不同之处在于，如果该队列为空，则会抛出异常
     * * @return
     */
    
    E element();
    
    /**
     * * 检索但不删除此队列的头，或如果此队列为空，则返回null。
     * * @return
     */
    
    E peek();
    
    /**
     * * 返回队列中元素个数
     * * @return
     */
    
    int size();
    
    /**
     * * 判断队列是否为空
     * * @return
     */
    
    boolean isEmpty();
}
