package com.leetcode._2025_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 1353. 最多可以参加的会议数目
 *
 * @author DHW
 * @date 2025/7/7 9: 29
 * @Version 1.0
*/
public class ProblemsNo1353 {

    @Test
    public void solution() {
        int[][] events = new int[][]{new int[]{3,4},new int[]{1,2},new int[]{2,3}};
        System.out.println("res = " + maxEvents(events));
    }

    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);


        int curTime = 1;
        int i = 0;
        while(!queue.isEmpty() || i < events.length) {
            while (i < events.length && events[i][0] <= curTime) {
                queue.add(events[i][1]);
                i++;
            }
            if(!queue.isEmpty()) {
                queue.poll();
                res++;
            }
            while (!queue.isEmpty() && queue.peek() <= curTime) {
                queue.poll();
            }
            curTime++;
        }

        return res;
    }

}

