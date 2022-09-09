package com.itheima.week4.binary_search_tree;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-11-30 11:18
 **/
public class BST_Test {
    @Test
    public void test() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(10);
        bst.add(15);
        bst.add(16);
        bst.add(17);
        bst.add(18);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(9);
        bst.add(10);
        bst.add(11);
        bst.add(12);
        bst.add(13);
        bst.add(4);
        bst.add(7);
        System.out.println(bst);
        // bst.remove(10);
        // System.out.println(bst);
        // bst.remove(18);
        // System.out.println(bst);
        // bst.remove(12);
        // System.out.println(bst);
        // bst.remove(1);
        // System.out.println(bst);
        
        System.out.println("最大节点值:" + bst.getMax().getVal());
        System.out.println("最小节点值:" + bst.getMin().getVal());
    }
}
