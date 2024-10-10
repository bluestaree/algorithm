package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayDeque;


/**
 * 2073. 买票需要的时间
 *
 * @author DHW
 * @date 2024/9/29 8:59
 * @Version 1.0
 */
public class ProblemsNo2073 {

    @Test
    public void solution() {
        int[] tickets = new int[]{4, 8, 2, 8};
        int k = 2;
        System.out.println("res = " + timeRequiredToBuy(tickets, k));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            deque.offer(new int[]{tickets[i], i});
        }
        int res = 0;
        while(!deque.isEmpty()) {
            res++;
            int[] a = deque.pop();
            if(--a[0] != 0) {
                deque.offer(a);
            } else if(a[1] == k){
                return res;
            }
        }
        return res;
    }
}

