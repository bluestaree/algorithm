package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1921. 消灭怪物的最大数量
 *
 * @author DHW
 * @date 2023/9/3 12:44
 * @Version 1.0
*/
public class ProblemsNo1921 {

    @Test
    public void solution() {
        int[] dist = new int[]{3,2,4};
        int[] speed = new int[]{5,3,2};
        System.out.println("res = " + eliminateMaximum(dist, speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = (dist[i] - 1) / speed[i];
        }
        Arrays.sort(d);
        for (int i = 0; i < n; i++) {
            if(d[i] <= i) {
               return i;
            }
        }
        return n;
    }
}
