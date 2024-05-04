package com.leetcode._2024_5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 2462. 雇佣 K 位工人的总代价
 *
 * @author DHW
 * @date 2024/5/1 10:22
 * @Version 1.0
*/
public class ProblemsNo2462 {

    @Test
    public void solution() {
        int k = 3;
        int candidates = 4;
        int[] costs = new int[]{17,12,10,2,7,2,11,20,8};
        System.out.println("res = " + totalCost(costs, k, candidates));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0l;
        int l = 0;
        int r = costs.length - 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        for (; l < candidates && l <= r; l++) {
            queue.add(new int[]{costs[l],l});
        }
        for (; r >= l && r >= costs.length - candidates; r--) {
            queue.add(new int[]{costs[r],r});
        }

        while(k > 0) {
            int[] a = queue.poll();
            res += a[0];
            k--;
            if(l <= r) {
                if(a[1] < r) {
                    queue.add(new int[]{costs[l],l});
                    l++;
                } else {
                    queue.add(new int[]{costs[r],r});
                    r--;
                }
            }
        }

        return res;
    }
}

