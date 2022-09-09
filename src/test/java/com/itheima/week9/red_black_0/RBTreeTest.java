package com.itheima.week9.red_black_0;

import com.itheima.week9.red_black.printer.BinaryTrees;

public class RBTreeTest {
    public static void main(String[] args) {
        int[] data = {55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50};
        RBTree rbTree = new RBTree();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------------");
        }
    }
}
