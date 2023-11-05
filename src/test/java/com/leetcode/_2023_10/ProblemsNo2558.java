package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2558. 从数量最多的堆取走礼物
 *
 * @author DHW
 * @date 2023/10/28 11:09
 * @Version 1.0
*/
public class ProblemsNo2558 {

    @Test
    public void solution() {
        int[] gifts = new int[]{25,64,9,4,100};
        int k = 4;
        System.out.println("res = " + pickGifts(gifts, k));
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        long res = 0;
        for (int i = 0; i < gifts.length; i++) {
            queue.add(gifts[i]);
            res += gifts[i];
        }

        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            int num = (int) Math.sqrt(poll);
            queue.add(num);
            res -= (poll - num);
        }
        return res;
    }
}

