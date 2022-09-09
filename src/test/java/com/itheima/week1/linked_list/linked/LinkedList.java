package com.itheima.week1.linked_list.linked;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-18 10:44
 **/
public class LinkedList<E> implements List<E> {
    private int size = 0;
    //要不要加null的初始值
    private Node<E> first = null;
    
    private Node<E> last = null;
    
    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;
        
        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int indexOf(E o) {
        int index = 0;
        //分情况 o是否为null，为null和不为null判断的方式不一样，null是用==，不为null用equals
        if (null == o) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (null == x.item) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
            
        }
        return -1;
    }
    
    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
        
    }
    
    @Override
    public boolean add(E e) {
        linkLast(e);
        
        return true;
    }
    
    private void linkLast(E e) {
        
        Node<E> node = last;
        last = new Node<>(node, e, null);
        //如何做其他
        if (null == node) {
            first = last;
        } else {
            node.next = last;
        }
        //长度增加了
        size++;
    }
    
    @Override
    public void add(int index, E element) {
        checkIndex(index);
        //    IndexOutOfBoundsException: Index: 3, Size: 0
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
            
        }
        
    }
    
    private void linkBefore(E element, Node<E> next) {
        Node<E> prev = next.prev;
        Node<E> curr = new Node<>(prev, element, next);
        //
        next.prev = curr;
        if (prev == null) {
            first = curr;
        } else {
            prev.next = curr;
        }
        size++;
    }
    
    private Node<E> node(int index) {
        //折半查找
        Node<E> curr;
        if (index < (size >> 1)) {
            
            curr = first;
            for (int i = 1; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            curr = last;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }
    
    private void checkIndex(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException(" Index: " + index + ", Size: " + size);
        }
    }
    
    @Override
    public E set(int index, E element) {
        isElementIndex(index);
        Node<E> curr = node(index);
        
        E old = curr.item;
        curr.item = element;
        return old;
    }
    
    private void isElementIndex(int index) {
        if (index >= size && index < 0) {
            throw new IndexOutOfBoundsException(" Index: " + index + ", Size: " + size);
        }
    }
    
    @Override
    public E get(int index) {
        isElementIndex(index);
        return node(index).item;
    }
    
    @Override
    public E remove(int index) {
        
        isElementIndex(index);
        Node<E> node = node(index);
        return unlink(node);
        
    }
    
    private E unlink(Node<E> curr) {
        
        Node<E> prev = curr.prev;
        Node<E> next = curr.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            curr.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            curr.next = null;
        }
        size--;
        return curr.item;
    }
    
    @Override
    public void clear() {
        //为啥需要呢
        for (Node<E> l = first; l != null; ) {
            Node<E> next = l.next;
            l.prev = null;
            l.next = null;
            l.item = null;
            l = next;
        }
        first = null;
        last = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder("[");
        for (Node<E> curr = first; curr != null; ) {
            sb.append(curr.item);
            curr = curr.next;
            if (curr != null) {
                sb.append(", ");
            } else {
                break;
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}
