package com.itheima.week9.red_black.printer;

public interface BinaryTreeInfo {
    /**
     * return root node
     */
    Object root();
    
    /**
     * get the left child of the node
     */
    Object left(Object node);
    
    /**
     * get the right child of the node
     */
    Object right(Object node);
    
    /**
     * print the node
     */
    Object string(Object node);
}
