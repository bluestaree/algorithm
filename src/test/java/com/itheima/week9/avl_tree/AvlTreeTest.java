package com.itheima.week9.avl_tree;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-31 14:09
 **/
public class AvlTreeTest {
    
    public static void main(String[] args) {
//testRR();
//testLL();
//testLR();
        testRL();
    }
    //测试RR情况
    
    public static void testRR() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        System.out.println(avlTree);
        avlTree.insert(4);
        avlTree.insert(5);
        System.out.println(avlTree);
        avlTree.insert(6);
        System.out.println(avlTree);
        avlTree.insert(7);
        avlTree.insert(8);
        avlTree.insert(9);
        System.out.println(avlTree);
        avlTree.insert(10);
    }
    
    public static void testLL() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(9);
        avlTree.insert(8);
        System.out.println(avlTree);
        avlTree.insert(7);
        avlTree.insert(6);
        System.out.println(avlTree);
        avlTree.insert(5);
        System.out.println(avlTree);
        avlTree.insert(4);
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        System.out.println(avlTree);
    }
    
    public static void testLR() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(7);
        avlTree.insert(9);
        System.out.println(avlTree);
        avlTree.insert(2);
        avlTree.insert(5);
        avlTree.insert(6);
        System.out.println(avlTree);
        avlTree.insert(3);
        avlTree.insert(1);
        avlTree.insert(4);
        System.out.println(avlTree);
    }
    
    public static void testRL() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(2);
        System.out.println(avlTree);
        avlTree.insert(9);
        avlTree.insert(6);
        System.out.println(avlTree);
        avlTree.insert(5);
        System.out.println(avlTree);
        avlTree.insert(8);
        avlTree.insert(10);
        avlTree.insert(7);
        System.out.println(avlTree);
    }
}
