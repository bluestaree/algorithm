package com.leetcode._2025_9;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3516. 找到最近的人
 *
 * @author DHW
 * @date 2025/9/4 9: 05
 * @Version 1.0
*/
public class ProblemsNo3516 {

    @Test
    public void solution() {
        int x = 4;
        int y = 4;
        int z = 4;
        System.out.println("res = " + findClosest(x, y, z));
    }

    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if(a == b) {
           return 0;
        } else if(a > b) {
            return 1;
        }
        return 2;
    }
}

