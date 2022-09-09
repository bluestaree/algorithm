package com.itheima.week9.red_black;

import com.itheima.week9.red_black.printer.BinaryTrees;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-10 19:13
 **/
public class RBTreeTest {
    public static void main(String[] args) {
        // testAdd();
        testRemove();
    }
    
    public static void testAdd() {
        int[] data = {55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50};
        RBTree rbTree = new RBTree();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------------");
        }
    }
    
    public static void testRemove() {
        int[] data = new int[]{55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50};
        RBTree rbTree = new RBTree();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
        }
        BinaryTrees.println(rbTree);
        for (int i = 0; i < data.length; i++) {
            rbTree.remove(data[i]);
            System.out.println("---------------------------------------");
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rbTree);
        }
    }
}
