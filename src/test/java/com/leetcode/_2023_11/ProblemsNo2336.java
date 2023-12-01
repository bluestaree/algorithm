package com.leetcode._2023_11;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 2336. 无限集中的最小数字
 *
 * @author DHW
 * @date 2023/11/29 10:22
 * @Version 1.0
*/
public class ProblemsNo2336 {

    @Test
    public void solution() {
        SmallestInfiniteSet obj = new SmallestInfiniteSet();
        int param_1 = obj.popSmallest();
        obj.addBack(1);
        System.out.println("res = " + obj.popSmallest());
    }

    class SmallestInfiniteSet {

        boolean[] b = new boolean[1001];
        PriorityQueue<Integer> queue;

        public SmallestInfiniteSet() {
            queue = new PriorityQueue();
            for (int i = 1; i < 1001; i++) {
                b[i] = true;
                queue.add(i);
            }
        }

        public int popSmallest() {
            Integer i = queue.poll();
            b[i] = false;
            return i;
        }

        public void addBack(int num) {
            if(!b[num]) {
                b[num] = true;
                queue.add(num);
            }
        }
    }
}

