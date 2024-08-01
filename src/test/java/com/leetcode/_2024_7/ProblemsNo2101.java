package com.leetcode._2024_7;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 2101. 引爆最多的炸弹
 *
 * @author DHW
 * @date 2024/7/22 10:28
 * @Version 1.0
*/
public class ProblemsNo2101 {

    @Test
    public void solution() {
        int[][] bombs = new int[][]{new int[]{0,1,10},new int[]{1,2,15},new int[]{0,3,10}};
        System.out.println("res = " + maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            boolean[] vis = new boolean[n];
            vis[i] = true;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.offer(bombs[i]);
            while(!deque.isEmpty()) {
                int[] pop = deque.pop();
                cnt++;
                for (int j = 0; j < n; j++) {
                    if(!vis[j]) {
                        double hypot = Math.hypot(pop[0] - bombs[j][0], pop[1] - bombs[j][1]);
                        if(hypot <= pop[2]) {
                            deque.offer(bombs[j]);
                            vis[j] = true;
                        }
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}


