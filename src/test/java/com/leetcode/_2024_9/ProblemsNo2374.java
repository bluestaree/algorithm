package com.leetcode._2024_9;

import org.junit.Test;

import java.util.*;


/**
 * 2374. 边积分最高的节点
 *
 * @author DHW
 * @date 2024/9/17 11:33
 * @Version 1.0
*/
public class ProblemsNo2374 {

    @Test
    public void solution() {
        int[] edges = new int[]{1,0,0,0,0,7,7,5};
        System.out.println("res = " + edgeScore(edges));
    }

    public int edgeScore(int[] edges) {
        int res = 0;
        long[] score = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int to = edges[i];
            score[to] += i;
            if(score[to] > score[res]  || score[to] == score[res] && to < res) {
                res = to;
            }
        }
        return res;
    }
}

