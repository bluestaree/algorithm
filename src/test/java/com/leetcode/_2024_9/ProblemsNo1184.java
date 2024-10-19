package com.leetcode._2024_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1184. 公交站间的距离
 *
 * @author DHW
 * @date 2024/9/16 10: 49
 * @Version 1.0
*/
public class ProblemsNo1184 {

    @Test
    public void solution() {
        int[] distance = new int[]{7,4,1};
        int start = 1;
        int destination = 5;
        System.out.println("res = " + distanceBetweenBusStops(distance, start, destination));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int t = start;
            start = destination;
            destination = t;
        }
        int res = 0;
        for (int i = start; i < destination; i++) {
            res += distance[i];
        }
        int sum = Arrays.stream(distance).sum();
        res = Math.min(sum - res , res);
        return res;
    }
}

